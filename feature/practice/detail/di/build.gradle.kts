plugins {
    alias(libs.plugins.practicecounter.di)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.detail.di"
}

dependencies {
    implementation(projects.core.storage)

    implementation(projects.feature.practice.detail.data)
    implementation(projects.feature.practice.detail.domain)
}