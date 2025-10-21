package fr.alefaux.practicecounter.feature.practice.detail.domain.model

import fr.alefaux.practicecounter.core.storage.seance.SeanceEntity

data class Seance(
    val date: String,
    val number: Int,
) {
    constructor(entity: SeanceEntity) : this(
        date = entity.date,
        number = entity.number,
    )
}