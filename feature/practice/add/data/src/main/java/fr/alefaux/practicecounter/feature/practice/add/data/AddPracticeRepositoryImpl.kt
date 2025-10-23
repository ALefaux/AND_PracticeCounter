package fr.alefaux.practicecounter.feature.practice.add.data

import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice
import javax.inject.Inject

class AddPracticeRepositoryImpl
    @Inject
    constructor(
        private val practiceDao: PracticeDao,
    ) : AddPracticeRepository {
        override suspend fun create(addPractice: AddPractice) {
            practiceDao.insert(addPractice.toEntity())
        }
    }
