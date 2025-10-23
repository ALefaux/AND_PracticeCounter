package fr.alefaux.practicecounter.feature.practice.add.data

import fr.alefaux.practicecounter.feature.practice.add.domain.CreatePracticeUseCase
import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice
import javax.inject.Inject

class CreatePracticeUseCaseImpl
@Inject
constructor(
    private val addPracticeRepository: AddPracticeRepository,
) : CreatePracticeUseCase {
    override suspend operator fun invoke(addPractice: AddPractice) =
        addPracticeRepository.create(addPractice)
}