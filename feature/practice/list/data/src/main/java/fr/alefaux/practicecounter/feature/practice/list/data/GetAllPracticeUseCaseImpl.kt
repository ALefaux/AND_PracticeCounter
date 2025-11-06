package fr.alefaux.practicecounter.feature.practice.list.data

import fr.alefaux.practicecounter.feature.practice.list.domain.GetAllPracticeUseCase
import fr.alefaux.practicecounter.feature.practice.list.domain.model.Practice
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPracticeUseCaseImpl @Inject constructor(
    private val repository: PracticeListRepository
): GetAllPracticeUseCase {
    override suspend fun invoke(): Flow<List<Practice>> = repository.fetchAll()
}