package fr.alefaux.practicecounter.feature.practice.detail.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.detail.domain.model.Practice
import kotlinx.coroutines.flow.Flow

interface PracticeDetailRepository {
    suspend fun findPracticeById(id: Int): Flow<Result<Practice>>

    suspend fun deletePracticeById(id: Int): Result<Unit>
}