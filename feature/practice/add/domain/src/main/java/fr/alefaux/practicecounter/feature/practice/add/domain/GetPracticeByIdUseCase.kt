package fr.alefaux.practicecounter.feature.practice.add.domain

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.add.domain.model.Practice

interface GetPracticeByIdUseCase {
    suspend operator fun invoke(id: Int): Result<Practice>
}