plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.add.presentation"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.feature.practice.add.panes)
}
