package fr.alefaux.practicecounter.feature.practice.detail.modelui

sealed interface PracticeDetailState {
    object Loading : PracticeDetailState
    data class Success(
        val objective: Int?,
        val seancesUi: List<SeanceUi>,
        val seanceToday: SeanceUi?
    ) : PracticeDetailState
    sealed interface Error : PracticeDetailState {
        data object NotFound: Error
        data object Unknown: Error
    }
}