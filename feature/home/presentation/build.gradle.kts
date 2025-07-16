plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.home.presentation"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.feature.home.panes)
}
