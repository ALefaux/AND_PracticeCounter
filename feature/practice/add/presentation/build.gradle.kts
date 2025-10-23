plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.add.presentation"
}

dependencies {
    implementation(projects.core.components)
    implementation(projects.core.designsystem)
    implementation(projects.core.navigation)
    implementation(projects.feature.practice.add.domain)
    implementation(projects.feature.practice.add.panes)
}
