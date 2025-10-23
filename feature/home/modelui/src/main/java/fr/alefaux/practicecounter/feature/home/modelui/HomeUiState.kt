package fr.alefaux.practicecounter.feature.home.modelui

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val practicesOfTheDay: List<PracticeUi>,
    ) : HomeUiState

    data object Empty : HomeUiState
}
