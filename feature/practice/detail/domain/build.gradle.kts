plugins {
    alias(libs.plugins.practicecounter.data.local)
    alias(libs.plugins.practicecounter.android.hilt)
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.detail.domain"
}

dependencies {
    implementation(projects.core.storage)
    implementation(projects.core.model)
}