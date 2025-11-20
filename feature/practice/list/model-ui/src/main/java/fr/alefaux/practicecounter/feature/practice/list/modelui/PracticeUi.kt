package fr.alefaux.practicecounter.feature.practice.list.modelui

data class PracticeUi(
    val id: Int,
    val lastExercise: String?,
    val objective: Int?,
    val name: String,
    val todayExercise: Int
)
