package fr.alefaux.practicecounter.feature.practice.list.data

import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.list.domain.model.Practice
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PracticeListRepositoryImpl @Inject constructor(
    private val practiceDao: PracticeDao
): PracticeListRepository {
    override suspend fun fetchAll(): Flow<List<Practice>> = practiceDao.getAllWithSeances()
        .map { practicesWithSeances ->
            practicesWithSeances.map { (practice, seances) ->
                Practice(
                    id = practice.id,
                    name = practice.title,
                )
            }
        }
}