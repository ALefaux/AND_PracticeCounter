package fr.alefaux.practicecounter.feature.practice.add.presentation

interface AddPracticeEvent {
    data class Error(
        val message: String,
    ) : AddPracticeEvent

    data object Created : AddPracticeEvent
}
