package fr.alefaux.practicecounter.feature.practice.detail.domain

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.home.domain.model.Practice

interface FindPracticeByIdUseCase {
    suspend operator fun invoke(id: Int): Result<Practice>
}