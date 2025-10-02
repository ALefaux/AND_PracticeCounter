package fr.alefaux.practicecounter.feature.practice.detail.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.home.domain.model.Practice

interface PracticeDetailRepository {
    suspend fun findPracticeById(id: Int): Result<Practice>
}