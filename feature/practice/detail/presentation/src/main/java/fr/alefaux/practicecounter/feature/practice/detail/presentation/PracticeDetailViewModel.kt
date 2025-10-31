package fr.alefaux.practicecounter.feature.practice.detail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.detail.domain.FindPracticeByIdUseCase
import fr.alefaux.practicecounter.feature.practice.detail.modelui.PracticeDetailState
import fr.alefaux.practicecounter.core.navigation.FeaturesDestinations
import fr.alefaux.practicecounter.feature.practice.detail.domain.DeletePracticeByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PracticeDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val deletePracticeByIdUseCase: DeletePracticeByIdUseCase,
    private val findPracticeByIdUseCase: FindPracticeByIdUseCase
) : ViewModel() {

    private var _title: MutableSharedFlow<String> = MutableSharedFlow()
    val title: SharedFlow<String> = _title

    private var _state: MutableStateFlow<PracticeDetailState> =
        MutableStateFlow(PracticeDetailState.Loading)
    val state: StateFlow<PracticeDetailState> = _state

    private var _deletePractice: MutableSharedFlow<Unit> = MutableSharedFlow()
    val deletePractice: SharedFlow<Unit> = _deletePractice

    val id: String = savedStateHandle[FeaturesDestinations.Practice.Detail.PARAM_ID]
        ?: error("Missing practice id")

    init {
        loadPracticeById()
    }

    private fun loadPracticeById() {
        viewModelScope.launch(Dispatchers.IO) {
            findPracticeByIdUseCase(id.toInt()).collect { result ->
                withContext(Dispatchers.Main) {
                    when (result) {
                        is Result.Success -> {
                            with(result.value) {
                                Timber.d("Loaded practice $title #$id")
                                _title.emit(title)
                                _state.emit(
                                    PracticeDetailState.Success(
                                        objective = result.value.objective,
                                        seancesUi = emptyList(),
                                        seanceToday = null
                                    )
                                )
                            }
                        }
                        is Result.Error.NotFound -> {
                            Timber.w("Couldn't find practice by id #$id")
                            _state.emit(PracticeDetailState.Error.NotFound)
                        }
                        else -> {
                            Timber.w("Result unknown")
                            _state.emit(PracticeDetailState.Error.Unknown)
                        }
                    }
                }
            }
        }
    }

    fun deletePractice() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                deletePracticeByIdUseCase(id.toInt())
            }.onSuccess {
                withContext(Dispatchers.Main) {
                    _deletePractice.emit(Unit)
                }
            }.onFailure { error ->
                Timber.w(error, "Couldn't delete practice by id #$id")
            }
        }
    }
}