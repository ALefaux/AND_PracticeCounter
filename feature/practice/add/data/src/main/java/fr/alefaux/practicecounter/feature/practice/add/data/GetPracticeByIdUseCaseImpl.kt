package fr.alefaux.practicecounter.feature.practice.add.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.add.domain.GetPracticeByIdUseCase
import fr.alefaux.practicecounter.feature.practice.add.domain.model.Practice
import javax.inject.Inject

class GetPracticeByIdUseCaseImpl @Inject constructor(
    private val addPracticeRepository: AddPracticeRepository
): GetPracticeByIdUseCase {
    override suspend fun invoke(id: Int): Result<Practice> =
        addPracticeRepository.getPracticeById(id)
}