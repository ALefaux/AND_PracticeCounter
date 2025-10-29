package fr.alefaux.practicecounter.feature.practice.detail.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.detail.domain.DeletePracticeByIdUseCase
import javax.inject.Inject

class DeletePracticeByIdUseCaseImpl @Inject constructor(
    private val practiceDetailRepository: PracticeDetailRepository
) : DeletePracticeByIdUseCase {
    override suspend fun invoke(id: Int): Result<Unit> =
        practiceDetailRepository.deletePracticeById(id)
}