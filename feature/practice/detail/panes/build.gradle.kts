plugins {
    alias(libs.plugins.practicecounter.panes)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.detail.panes"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.components)
    implementation(projects.feature.practice.detail.modelui)
}