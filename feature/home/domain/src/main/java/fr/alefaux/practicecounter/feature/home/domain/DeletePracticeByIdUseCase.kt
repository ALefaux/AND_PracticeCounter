package fr.alefaux.practicecounter.feature.home.domain

interface DeletePracticeByIdUseCase {
    suspend operator fun invoke(id: Int)
}