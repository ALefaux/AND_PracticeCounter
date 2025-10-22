package fr.alefaux.practicecounter.feature.home.domain

import fr.alefaux.practicecounter.feature.home.domain.model.HomeData
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface GetHomeDataUseCase {
    suspend operator fun invoke(dateNow: Date): Flow<HomeData>
}
