package fr.alefaux.practicecounter.feature.home.data

import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.core.storage.practice.PracticeWithSeances
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val practiceDao: PracticeDao
) : HomeRepository {
    override suspend fun getAllPracticeWithSeances(): Flow<List<PracticeWithSeances>> =
        practiceDao.getAllWithSeances().map { practiceWithSeances ->
            practiceWithSeances.filter { !it.practice.deleted }
        }

    override suspend fun deletePracticeById(id: Int) {
        practiceDao.findPracticeAndSeanceById(id)?.also { practice ->
            practiceDao.delete(practice.practice)
        }
    }
}
