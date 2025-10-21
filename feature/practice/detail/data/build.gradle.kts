plugins {
    alias(libs.plugins.practicecounter.data.local)
    alias(libs.plugins.practicecounter.android.hilt)
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.detail.data"
}

dependencies {
    implementation(projects.core.storage)
    implementation(projects.core.model)

    implementation(projects.feature.practice.detail.domain)
}