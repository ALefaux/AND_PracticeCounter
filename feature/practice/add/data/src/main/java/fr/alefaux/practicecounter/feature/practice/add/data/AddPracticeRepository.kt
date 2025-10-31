package fr.alefaux.practicecounter.feature.practice.add.data

import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice
import fr.alefaux.practicecounter.feature.practice.add.domain.model.Practice

interface AddPracticeRepository {
    suspend fun create(addPractice: AddPractice)

    suspend fun update(id: Int, objective: Int?): Result<Unit>

    suspend fun getPracticeById(id: Int): Result<Practice>
}
