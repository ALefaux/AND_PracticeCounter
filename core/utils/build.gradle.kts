plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "fr.alefaux.practicecounter.core.utils"
    compileSdk =
        libs.versions.androidCompileSdk
            .get()
            .toInt()

    defaultConfig {
        minSdk =
            libs.versions.androidMinSdk
                .get()
                .toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}