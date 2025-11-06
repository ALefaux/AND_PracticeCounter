package fr.alefaux.practicecounter.feature.practice.list.data

import fr.alefaux.practicecounter.feature.practice.list.domain.model.Practice
import kotlinx.coroutines.flow.Flow

interface PracticeListRepository {
    suspend fun fetchAll(): Flow<List<Practice>>
}