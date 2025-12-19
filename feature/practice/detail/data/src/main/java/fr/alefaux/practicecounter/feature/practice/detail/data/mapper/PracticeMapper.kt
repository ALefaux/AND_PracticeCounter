package fr.alefaux.practicecounter.feature.practice.detail.data.mapper

import fr.alefaux.practicecounter.core.storage.practice.PracticeWithSeances
import fr.alefaux.practicecounter.core.storage.seance.SeanceEntity
import fr.alefaux.practicecounter.feature.practice.detail.domain.model.Practice
import fr.alefaux.practicecounter.feature.practice.detail.domain.model.Seance

fun PracticeWithSeances.toDomain(): Practice = Practice(
    id = this.practice.id,
    title = this.practice.title,
    objective = this.practice.objective,
    seances = this.seances.map { it.toDomain() },
)

fun SeanceEntity.toDomain(): Seance = Seance(
    date = this.date,
    number = this.number,
)