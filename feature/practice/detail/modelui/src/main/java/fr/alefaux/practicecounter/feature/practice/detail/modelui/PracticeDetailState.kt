package fr.alefaux.practicecounter.feature.practice.detail.modelui

sealed interface PracticeDetailState {
    object Loading : PracticeDetailState
    data class Success(
        val objective: Int?,
        val seancesUi: List<String>
    ) : PracticeDetailState
    sealed interface Error : PracticeDetailState {
        data object NotFound: Error
        data object Unknown: Error
    }
}