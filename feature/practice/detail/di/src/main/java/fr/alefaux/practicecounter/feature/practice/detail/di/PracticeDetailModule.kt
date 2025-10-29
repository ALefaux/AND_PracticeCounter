package fr.alefaux.practicecounter.feature.practice.detail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.detail.data.DeletePracticeByIdUseCaseImpl
import fr.alefaux.practicecounter.feature.practice.detail.data.FindPracticeByIdUseCaseImpl
import fr.alefaux.practicecounter.feature.practice.detail.data.PracticeDetailRepository
import fr.alefaux.practicecounter.feature.practice.detail.data.PracticeDetailRepositoryImpl
import fr.alefaux.practicecounter.feature.practice.detail.domain.DeletePracticeByIdUseCase
import fr.alefaux.practicecounter.feature.practice.detail.domain.FindPracticeByIdUseCase

@Module
@InstallIn(ViewModelComponent::class)
class PracticeDetailModule {
    @Provides
    fun providePracticeDetailRepository(practiceDao: PracticeDao): PracticeDetailRepository =
        PracticeDetailRepositoryImpl(practiceDao)

    @Provides
    fun provideFindPracticeByIdUseCase(
        practiceDetailRepository: PracticeDetailRepository
    ): FindPracticeByIdUseCase = FindPracticeByIdUseCaseImpl(practiceDetailRepository)

    @Provides
    fun provideDeletePracticeByIdUseCase(
        practiceDetailRepository: PracticeDetailRepository
    ): DeletePracticeByIdUseCase = DeletePracticeByIdUseCaseImpl(practiceDetailRepository)
}