package fr.alefaux.practicecounter.feature.practice.add.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.feature.practice.add.data.AddPracticeRepository
import fr.alefaux.practicecounter.feature.practice.add.data.AddPracticeRepositoryImpl
import fr.alefaux.practicecounter.feature.practice.add.domain.CreatePracticeUseCase
import fr.alefaux.practicecounter.feature.practice.add.domain.CreatePracticeUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
class PracticeAddModule {

    @Provides
    fun providePracticeRepository(
        practiceDao: PracticeDao
    ): AddPracticeRepository = AddPracticeRepositoryImpl(practiceDao)

    @Provides
    fun provideCreatePracticeUseCase(
        addPracticeRepository: AddPracticeRepository
    ): CreatePracticeUseCase = CreatePracticeUseCaseImpl(addPracticeRepository)
}
