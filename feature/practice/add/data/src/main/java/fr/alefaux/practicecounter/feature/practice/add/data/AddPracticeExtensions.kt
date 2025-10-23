package fr.alefaux.practicecounter.feature.practice.add.data

import fr.alefaux.practicecounter.core.storage.practice.PracticeEntity
import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice

fun AddPractice.toEntity(): PracticeEntity =
    PracticeEntity(
        title = title,
        objective = objective,
    )
