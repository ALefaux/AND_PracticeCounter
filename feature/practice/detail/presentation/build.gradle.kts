plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.detail.presentation"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.model)
    implementation(projects.core.navigation)
    implementation(projects.feature.practice.detail.panes)
    implementation(projects.feature.practice.detail.domain)
    implementation(projects.feature.practice.detail.modelui)
}