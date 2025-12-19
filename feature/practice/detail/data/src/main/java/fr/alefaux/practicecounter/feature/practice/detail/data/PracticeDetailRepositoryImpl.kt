package fr.alefaux.practicecounter.feature.practice.detail.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.detail.data.mapper.toDomain
import fr.alefaux.practicecounter.feature.practice.detail.domain.model.Practice
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PracticeDetailRepositoryImpl @Inject constructor(
    private val practiceDao: PracticeDao
): PracticeDetailRepository {
    override suspend fun findPracticeById(id: Int): Flow<Result<Practice>> {
        return try {
            practiceDao.findPracticeAndSeanceByIdFlow(id).map { practiceWithSeances ->
                if (practiceWithSeances == null) {
                    Result.Error.NotFound
                } else {
                    Result.Success(
                        value = practiceWithSeances.toDomain()
                    )
                }
            }
        } catch (e: Exception) {
            flowOf(Result.Error.Unknown)
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