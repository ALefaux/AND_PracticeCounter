package fr.alefaux.practicecounter.feature.practice.add.presentation.model

interface AddPracticeEvent {
    data class Error(
        val message: String,
    ) : AddPracticeEvent

    data object Created : AddPracticeEvent
    data object Updated : AddPracticeEvent
}