plugins {
    alias(libs.plugins.practicecounter.ui)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.detail.ui"
}

dependencies {
    implementation(projects.core.designsystem)
}