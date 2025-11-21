plugins {
    alias(libs.plugins.practicecounter.domain)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.home.domain"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.utils)
}