package fr.alefaux.practicecounter.feature.practice.add.data

import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice

interface AddPracticeRepository {
    suspend fun create(addPractice: AddPractice)
}
