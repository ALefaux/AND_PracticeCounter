package fr.alefaux.practicecounter.feature.practice.add.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.add.data.mapper.toDomain
import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice
import fr.alefaux.practicecounter.feature.practice.add.domain.model.Practice
import javax.inject.Inject

class AddPracticeRepositoryImpl @Inject constructor(
    private val practiceDao: PracticeDao,
) : AddPracticeRepository {
    override suspend fun create(addPractice: AddPractice) {
        practiceDao.insert(addPractice.toEntity())
    }

    override suspend fun update(id: Int, objective: Int?): Result<Unit> {
        return try {
            practiceDao.findPracticeById(id)?.let {
                val newPractice = it.copy(
                    objective = objective
                )
                practiceDao.update(newPractice)
                Result.Success(Unit)
            } ?: Result.Error.NotFound
        } catch (e: Exception) {
            Result.Error.Unknown
        }
    }

    override suspend fun getPracticeById(id: Int): Result<Practice> {
        return try {
            practiceDao.findPracticeById(id)?.let {
                Result.Success(
                    value = it.toDomain()
                )
            } ?: Result.Error.NotFound
        } catch (e: Exception) {
            Result.Error.Unknown
        }
    }
}
