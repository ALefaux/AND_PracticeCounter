package fr.alefaux.practicecounter.feature.home.data

import fr.alefaux.practicecounter.core.storage.practice.PracticeWithSeances
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getAllPracticeWithSeances(): Flow<List<PracticeWithSeances>>
}
