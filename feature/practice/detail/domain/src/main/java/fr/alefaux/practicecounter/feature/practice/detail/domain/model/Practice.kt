package fr.alefaux.practicecounter.feature.practice.detail.domain.model

import fr.alefaux.practicecounter.core.storage.practice.PracticeEntity
import fr.alefaux.practicecounter.core.storage.seance.SeanceEntity

data class Practice(
    val id: Int?,
    val title: String,
    val objective: Int?,
    val seances: List<Seance>,
) {
    constructor(
        practiceEntity: PracticeEntity,
        seanceEntities: List<SeanceEntity>,
    ) : this(
        id = practiceEntity.id,
        title = practiceEntity.title,
        objective = practiceEntity.objective,
        seances = seanceEntities.map { Seance(it) },
    )
}