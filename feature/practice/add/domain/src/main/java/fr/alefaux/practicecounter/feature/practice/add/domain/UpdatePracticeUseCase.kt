package fr.alefaux.practicecounter.feature.practice.add.domain

import fr.alefaux.practicecounter.core.model.Result

interface UpdatePracticeUseCase {
    suspend operator fun invoke(id: Int, objective: Int?): Result<Unit>
}