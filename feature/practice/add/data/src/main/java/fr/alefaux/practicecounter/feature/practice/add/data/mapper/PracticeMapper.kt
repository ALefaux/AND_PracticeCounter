package fr.alefaux.practicecounter.feature.practice.add.data.mapper

import fr.alefaux.practicecounter.core.storage.practice.PracticeEntity
import fr.alefaux.practicecounter.feature.practice.add.domain.model.Practice

fun PracticeEntity.toDomain(): Practice = Practice(
    id = this.id ?: -1,
    title = this.title,
    objective = this.objective
)