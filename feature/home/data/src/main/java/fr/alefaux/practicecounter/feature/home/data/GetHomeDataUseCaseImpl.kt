package fr.alefaux.practicecounter.feature.home.data

import fr.alefaux.practicecounter.core.utils.extensions.format
import fr.alefaux.practicecounter.feature.home.data.mapper.toDomain
import fr.alefaux.practicecounter.feature.home.domain.GetHomeDataUseCase
import fr.alefaux.practicecounter.feature.home.domain.model.HomeData
import fr.alefaux.practicecounter.feature.home.domain.model.Practice
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject

class GetHomeDataUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository,
) : GetHomeDataUseCase {
    override suspend operator fun invoke(dateNow: Date): Flow<HomeData> =
        homeRepository
            .getAllPracticeWithSeances()
            .map { practiceWithSeancesList ->
                HomeData(
                    practicesOfTheDay = practiceWithSeancesList.map { it.toDomain() },
                )
            }
}
