package fr.alefaux.practicecounter.feature.practice.detail.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.detail.domain.FindPracticeByIdUseCase
import fr.alefaux.practicecounter.feature.practice.detail.domain.model.Practice
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindPracticeByIdUseCaseImpl @Inject constructor(
    private val practiceDetailRepository: PracticeDetailRepository
) : FindPracticeByIdUseCase {
    override suspend fun invoke(id: Int): Flow<Result<Practice>> =
        practiceDetailRepository.findPracticeById(id)
}