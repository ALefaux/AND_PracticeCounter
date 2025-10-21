import java.util.Properties

plugins {
    alias(libs.plugins.practicecounter.android.application)
    alias(libs.plugins.practicecounter.android.application.compose)
    alias(libs.plugins.practicecounter.android.hilt)
}

android {
    namespace = "fr.alefaux.practicecounter"

    defaultConfig {
        applicationId = "fr.alefaux.practicecounter"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // load the values from .properties file
        val keystoreFile = project.rootProject.file("secrets.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())

        // return empty key in case something goes wrong
        val appWriteProjectId = properties.getProperty("APPWRITE_PROJECT_ID") ?: ""

        buildConfigField(
            type = "String",
            name = "APPWRITE_PROJECT_ID",
            value = appWriteProjectId,
        )
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.storage)
    implementation(projects.core.components)
    implementation(projects.core.navigation)

    // Feature modules
    implementation(projects.feature.home.presentation)
    implementation(projects.feature.practice.add.presentation)
    implementation(projects.feature.practice.detail.presentation)
    implementation(projects.feature.practice.detail.di)

    implementation(libs.androidx.core.ktx)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.navigation)

    // AppWrite
    implementation(libs.appwrite.android)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // Timber
    implementation(libs.jakewharton.timber)

    // Material Icons
    implementation(libs.androidx.compose.material.core)
    implementation(libs.androidx.compose.material.extended)

    // Flocon
    debugImplementation(libs.flocon)

}
