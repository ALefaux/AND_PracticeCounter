package fr.alefaux.practicecounter.feature.practice.add.domain

import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice

interface CreatePracticeUseCase {
    suspend operator fun invoke(addPractice: AddPractice)
}