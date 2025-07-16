package fr.alefaux.practicecounter.feature.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.home.data.GetHomeDataUseCaseImpl
import fr.alefaux.practicecounter.feature.home.data.HomeRepository
import fr.alefaux.practicecounter.feature.home.data.HomeRepositoryImpl
import fr.alefaux.practicecounter.feature.home.domain.GetHomeDataUseCase

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {
    @Provides
    fun provideHomeRepository(practiceDao: PracticeDao): HomeRepository = HomeRepositoryImpl(practiceDao)

    @Provides
    fun provideGetHomeDataUseCase(homeRepository: HomeRepository): GetHomeDataUseCase = GetHomeDataUseCaseImpl(homeRepository)
}
