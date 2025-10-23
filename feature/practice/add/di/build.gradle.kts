plugins {
    alias(libs.plugins.practicecounter.di)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.add.di"
}

dependencies {
    implementation(projects.core.storage)

    implementation(projects.feature.practice.add.data)
    implementation(projects.feature.practice.add.domain)
}