package fr.alefaux.practicecounter.feature.practice.list.presentation.model

import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi
import kotlinx.collections.immutable.ImmutableList

sealed interface PracticeListUiState {
    object Loading : PracticeListUiState

    data class Success(
        val practices: ImmutableList<PracticeUi>,
    ) : PracticeListUiState
    data object Empty: PracticeListUiState
}
