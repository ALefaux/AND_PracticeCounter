plugins {
    alias(libs.plugins.practicecounter.di)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.home.di"
}

dependencies {
    implementation(projects.core.storage)

    implementation(projects.feature.home.data)
    implementation(projects.feature.home.domain)
}