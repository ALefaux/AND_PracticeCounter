package fr.alefaux.practicecounter.feature.practice.list.presentation.model

import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi

sealed interface PracticeListUiState {
    object Loading : PracticeListUiState

    data class Success(
        val practices: List<PracticeUi>,
    ) : PracticeListUiState
    data object Empty: PracticeListUiState
}
