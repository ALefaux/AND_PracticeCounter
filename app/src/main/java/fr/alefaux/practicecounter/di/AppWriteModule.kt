package fr.alefaux.practicecounter.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import fr.alefaux.practicecounter.BuildConfig
import io.appwrite.Client

@Module
@InstallIn(ActivityComponent::class)
object AppWriteModule {

    @Provides
    fun provideAppWriteInstance(
        @ApplicationContext context: Context
    ): Client = Client(context).setProject(BuildConfig.APPWRITE_PROJECT_ID)
}