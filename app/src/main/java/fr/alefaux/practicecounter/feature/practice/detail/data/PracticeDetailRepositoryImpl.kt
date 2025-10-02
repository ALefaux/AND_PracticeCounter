package fr.alefaux.practicecounter.feature.practice.detail.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.home.domain.model.Practice
import javax.inject.Inject

class PracticeDetailRepositoryImpl @Inject constructor(
    private val practiceDao: PracticeDao
): PracticeDetailRepository {
    override suspend fun findPracticeById(id: Int): Result<Practice> {
        return try {
            practiceDao.findById(id)?.let {
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
}