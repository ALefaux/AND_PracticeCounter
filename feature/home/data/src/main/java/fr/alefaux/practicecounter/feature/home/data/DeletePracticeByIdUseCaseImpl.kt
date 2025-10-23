package fr.alefaux.practicecounter.feature.home.data

import fr.alefaux.practicecounter.feature.home.domain.DeletePracticeByIdUseCase
import javax.inject.Inject

class DeletePracticeByIdUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository,
) : DeletePracticeByIdUseCase {
    override suspend fun invoke(id: Int) = homeRepository.deletePracticeById(id)
}