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

    val title: SharedFlow<String>
        field = MutableSharedFlow()

    val state: StateFlow<PracticeDetailState>
        field = MutableStateFlow<PracticeDetailState>(PracticeDetailState.Loading)

    val deletePractice: SharedFlow<Unit>
        field = MutableSharedFlow()

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
                            Timber.d("Loaded practice ${result.value.title} #$id")
                            title.emit(result.value.title)
                            state.emit(
                                PracticeDetailState.Success(
                                    objective = result.value.objective,
                                    seancesUi = emptyList(),
                                    seanceToday = null
                                )
                            )
                        }

                        is Result.Error.NotFound -> {
                            Timber.w("Couldn't find practice by id #$id")
                            state.emit(PracticeDetailState.Error.NotFound)
                        }

                        else -> {
                            Timber.w("Result unknown")
                            state.emit(PracticeDetailState.Error.Unknown)
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
                    deletePractice.emit(Unit)
                }
            }.onFailure { error ->
                Timber.w(error, "Couldn't delete practice by id #$id")
            }
        }
    }
}