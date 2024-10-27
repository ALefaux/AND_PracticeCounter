plugins {
    alias(libs.plugins.practicecounter.android.application)
    alias(libs.plugins.practicecounter.android.application.compose)
    alias(libs.plugins.practicecounter.android.hilt)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "fr.alefaux.practicecounter"

    defaultConfig {
        applicationId = "fr.alefaux.practicecounter"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
}