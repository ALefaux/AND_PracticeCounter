plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.add.presentation"
}

dependencies {
    implementation(projects.feature.practice.add.domain)
    implementation(projects.feature.practice.add.modelui)
    implementation(projects.feature.practice.add.panes)

    implementation(libs.androidx.compose.material.core)
}
