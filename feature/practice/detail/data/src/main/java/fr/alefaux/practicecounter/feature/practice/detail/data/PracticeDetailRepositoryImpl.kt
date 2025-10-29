package fr.alefaux.practicecounter.feature.practice.detail.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.detail.domain.model.Practice
import javax.inject.Inject

class PracticeDetailRepositoryImpl @Inject constructor(
    private val practiceDao: PracticeDao
): PracticeDetailRepository {
    override suspend fun findPracticeById(id: Int): Result<Practice> {
        return try {
            practiceDao.findPracticeAndSeanceById(id)?.let {
                Result.Success(
                    value = Practice(
                        practiceEntity = it.practice,
                        seanceEntities = it.seances
                    )
                )
            } ?: Result.Error.NotFound
        } catch (e: Exception) {
            Result.Error.Unknown
        }
    }

    override suspend fun deletePracticeById(id: Int): Result<Unit> {
        return try {
            practiceDao.findPracticeById(id)?.let { practice ->
                val updatePractice = practice.copy(
                    deleted = true
                )
                practiceDao.update(updatePractice)
                Result.Success(Unit)
            } ?: Result.Error.NotFound
        } catch (e: Exception) {
            Result.Error.Unknown
        }
    }
}