package fr.alefaux.practicecounter.feature.home.domain.model

data class Practice(
    val id: Int?,
    val title: String,
    val objective: Int?,
    val seances: List<Seance>,
)
