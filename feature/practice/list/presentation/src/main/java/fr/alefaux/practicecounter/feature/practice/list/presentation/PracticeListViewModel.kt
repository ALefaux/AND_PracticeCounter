package fr.alefaux.practicecounter.feature.practice.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.alefaux.practicecounter.feature.practice.list.presentation.model.PracticeListUiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PracticeListViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {
    private var _state: MutableStateFlow<PracticeListUiState> =
        MutableStateFlow(PracticeListUiState.Loading)
    val state: StateFlow<PracticeListUiState> = _state

    init {
        loadPractices()
    }

    fun loadPractices() {
        viewModelScope.launch(dispatcher) {
            _state.update {
                PracticeListUiState.Success(emptyList())
            }
        }
    }
}