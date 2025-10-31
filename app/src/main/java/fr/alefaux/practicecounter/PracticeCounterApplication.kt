package fr.alefaux.practicecounter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.github.openflocon.flocon.Flocon
import timber.log.Timber

@HiltAndroidApp
class PracticeCounterApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Flocon.initialize(this)
    }
}
