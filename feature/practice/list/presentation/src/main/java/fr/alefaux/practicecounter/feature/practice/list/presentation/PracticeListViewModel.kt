package fr.alefaux.practicecounter.feature.practice.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.alefaux.practicecounter.core.utils.extensions.formatForDisplay
import fr.alefaux.practicecounter.feature.practice.list.domain.GetAllPracticeUseCase
import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi
import fr.alefaux.practicecounter.feature.practice.list.presentation.model.PracticeListUiState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PracticeListViewModel @Inject constructor(
    private val getAllPracticeUseCase: GetAllPracticeUseCase
) : ViewModel() {
    private var _state: MutableStateFlow<PracticeListUiState> =
        MutableStateFlow(PracticeListUiState.Loading)
    val state: StateFlow<PracticeListUiState> = _state

    init {
        loadPractices()
    }

    fun loadPractices() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllPracticeUseCase()
                .collect { practices ->
                    if (practices.isNotEmpty()) {
                        practices.map {
                            PracticeUi(
                                id = it.id ?: -1,
                                lastExercise = it.last?.formatForDisplay(),
                                name = it.name,
                                objective = it.objective,
                                todayExercise = it.today ?: 0
                            )
                        }.toImmutableList().also { practiceUis ->
                            _state.update { PracticeListUiState.Success(practiceUis) }
                        }
                    } else {
                        _state.update { PracticeListUiState.Empty }
                    }
                }
        }
    }
}
