plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.detail.presentation"
}

dependencies {
    implementation(projects.feature.practice.detail.domain)
    implementation(projects.feature.practice.detail.modelui)
    implementation(projects.feature.practice.detail.panes)

    implementation(libs.androidx.compose.material.core)
}