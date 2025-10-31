package fr.alefaux.practicecounter.feature.practice.detail.domain

import fr.alefaux.practicecounter.core.model.Result

interface DeletePracticeByIdUseCase {
    suspend operator fun invoke(id: Int): Result<Unit>
}