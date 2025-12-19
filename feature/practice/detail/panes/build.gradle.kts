plugins {
    alias(libs.plugins.practicecounter.panes)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.detail.panes"
}

dependencies {
    implementation(projects.feature.practice.detail.modelui)
    implementation(projects.feature.practice.detail.ui)
}