package fr.alefaux.practicecounter.feature.home.data

import fr.alefaux.practicecounter.core.utils.extensions.toDateEntity
import fr.alefaux.practicecounter.feature.home.domain.GetHomeDataUseCase
import fr.alefaux.practicecounter.feature.home.domain.model.HomeData
import fr.alefaux.practicecounter.feature.home.domain.model.Practice
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject

class GetHomeDataUseCaseImpl
    @Inject
    constructor(
        private val homeRepository: HomeRepository,
    ) : GetHomeDataUseCase {
        override suspend operator fun invoke(dateNow: Date): Flow<HomeData> =
            homeRepository
                .getAllPracticeWithSeances()
                .map { practiceWithSeancesList ->
                    val practices: List<Practice> =
                        practiceWithSeancesList.map { practiceWithSeances ->
                            Practice(
                                practiceEntity = practiceWithSeances.practice,
                                seanceEntities =
                                    practiceWithSeances.seances.filter { seance ->
                                        seance.date == dateNow.toDateEntity()
                                    },
                            )
                        }

                    HomeData(
                        practicesOfTheDay = practices,
                    )
                }
    }
