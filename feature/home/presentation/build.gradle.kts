plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.home.presentation"
}

dependencies {
    implementation(projects.feature.home.domain)
    implementation(projects.feature.home.modelui)
    implementation(projects.feature.home.panes)

    implementation(libs.androidx.compose.material.core)
}
