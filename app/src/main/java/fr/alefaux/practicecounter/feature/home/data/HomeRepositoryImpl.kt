package fr.alefaux.practicecounter.feature.home.data

import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.core.storage.practice.PracticeWithSeances
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl
    @Inject
    constructor(
        private val practiceDao: PracticeDao,
    ) : HomeRepository {
        override suspend fun getAllPracticeWithSeances(): Flow<List<PracticeWithSeances>> = practiceDao.getAllWithSeances()
    }
