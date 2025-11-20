package fr.alefaux.practicecounter.feature.practice.list.domain.model

import java.util.Date

data class Practice(
    val id: Int?,
    val name: String,
    val objective: Int?,
    val today: Int?,
    val last: Date?
)