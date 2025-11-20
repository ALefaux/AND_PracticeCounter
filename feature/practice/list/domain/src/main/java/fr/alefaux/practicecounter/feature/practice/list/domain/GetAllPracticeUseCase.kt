package fr.alefaux.practicecounter.feature.practice.list.domain

import fr.alefaux.practicecounter.feature.practice.list.domain.model.Practice
import kotlinx.coroutines.flow.Flow


interface GetAllPracticeUseCase {
    suspend operator fun invoke(): Flow<List<Practice>>
}