package fr.alefaux.practicecounter.feature.practice.add.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.add.domain.UpdatePracticeUseCase
import javax.inject.Inject

class UpdatePracticeUseCaseImpl @Inject constructor(
    private val addPracticeRepository: AddPracticeRepository
): UpdatePracticeUseCase {
    override suspend fun invoke(id: Int, objective: Int?): Result<Unit> =
        addPracticeRepository.update(id, objective)
}