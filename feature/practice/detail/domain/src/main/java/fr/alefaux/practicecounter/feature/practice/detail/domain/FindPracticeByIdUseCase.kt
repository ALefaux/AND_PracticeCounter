package fr.alefaux.practicecounter.feature.practice.detail.domain

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.detail.domain.model.Practice
import kotlinx.coroutines.flow.Flow

interface FindPracticeByIdUseCase {
    suspend operator fun invoke(id: Int): Flow<Result<Practice>>
}