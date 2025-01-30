package fr.alefaux.practicecounter.core.storage.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.alefaux.practicecounter.core.storage.PracticeCounterDatabase
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreStorageModule {

    @Provides
    @Singleton
    fun providePracticeCounterDatabase(
        @ApplicationContext context: Context
    ): PracticeCounterDatabase =
        Room.databaseBuilder(
            context,
            PracticeCounterDatabase::class.java,
            "practice-counter"
        ).build()

    @Provides
    fun providePracticeDao(
        practiceCounterDatabase: PracticeCounterDatabase
    ): PracticeDao = practiceCounterDatabase.practiceDao()
}