import java.util.Properties

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

        //load the values from .properties file
        val keystoreFile = project.rootProject.file("secrets.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())

        //return empty key in case something goes wrong
        val appWriteProjectId = properties.getProperty("APPWRITE_PROJECT_ID") ?: ""

        buildConfigField(
            type = "String",
            name = "APPWRITE_PROJECT_ID",
            value = appWriteProjectId
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
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)

    // AppWrite
    implementation(libs.appwrite.android)
}