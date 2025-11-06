plugins {
    alias(libs.plugins.practicecounter.di)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.list.di"
}

dependencies {
    implementation(projects.core.storage)

    implementation(projects.feature.practice.list.data)
    implementation(projects.feature.practice.list.domain)
}