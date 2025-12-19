plugins {
    alias(libs.plugins.practicecounter.domain)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.add.domain"
}

dependencies {
    implementation(projects.core.model)
}