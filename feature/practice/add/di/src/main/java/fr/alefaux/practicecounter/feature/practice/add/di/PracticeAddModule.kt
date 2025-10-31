package fr.alefaux.practicecounter.feature.practice.add.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.add.data.AddPracticeRepository
import fr.alefaux.practicecounter.feature.practice.add.data.AddPracticeRepositoryImpl
import fr.alefaux.practicecounter.feature.practice.add.domain.CreatePracticeUseCase
import fr.alefaux.practicecounter.feature.practice.add.data.CreatePracticeUseCaseImpl
import fr.alefaux.practicecounter.feature.practice.add.data.GetPracticeByIdUseCaseImpl
import fr.alefaux.practicecounter.feature.practice.add.data.UpdatePracticeUseCaseImpl
import fr.alefaux.practicecounter.feature.practice.add.domain.GetPracticeByIdUseCase
import fr.alefaux.practicecounter.feature.practice.add.domain.UpdatePracticeUseCase

@Module
@InstallIn(ViewModelComponent::class)
class PracticeAddModule {
    @Provides
    fun providePracticeRepository(practiceDao: PracticeDao): AddPracticeRepository = AddPracticeRepositoryImpl(practiceDao)

    @Provides
    fun provideCreatePracticeUseCase(addPracticeRepository: AddPracticeRepository): CreatePracticeUseCase =
        CreatePracticeUseCaseImpl(addPracticeRepository)

    @Provides
    fun provideGetPracticeUseCase(addPracticeRepository: AddPracticeRepository): GetPracticeByIdUseCase =
        GetPracticeByIdUseCaseImpl(addPracticeRepository)

    @Provides
    fun provideUpdatePracticeUseCase(addPracticeRepository: AddPracticeRepository): UpdatePracticeUseCase =
        UpdatePracticeUseCaseImpl(addPracticeRepository)
}
