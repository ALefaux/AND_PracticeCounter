package fr.alefaux.practicecounter.feature.practice.list.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.list.data.GetAllPracticeUseCaseImpl
import fr.alefaux.practicecounter.feature.practice.list.data.PracticeListRepository
import fr.alefaux.practicecounter.feature.practice.list.data.PracticeListRepositoryImpl
import fr.alefaux.practicecounter.feature.practice.list.domain.GetAllPracticeUseCase

@Module
@InstallIn(ViewModelComponent::class)
class PracticeListModule {
    @Provides
    fun providePracticeListRepository(practiceDao: PracticeDao): PracticeListRepository =
        PracticeListRepositoryImpl(practiceDao)

    @Provides
    fun provideGetAllPracticeUseCase(repository: PracticeListRepository): GetAllPracticeUseCase =
        GetAllPracticeUseCaseImpl(repository)
}