package fr.alefaux.practicecounter.feature.practice.add.domain.model

import fr.alefaux.practicecounter.core.storage.practice.PracticeEntity

data class Practice(
    val id: Int,
    val title: String,
    val objective: Int?
) {
    constructor(
        practiceEntity: PracticeEntity
    ) : this(
        id = practiceEntity.id ?: -1,
        title = practiceEntity.title,
        objective = practiceEntity.objective
    )
}
