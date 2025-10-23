plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.home.presentation"
}

dependencies {
    implementation(projects.core.components)
    implementation(projects.core.designsystem)
    implementation(projects.core.navigation)
    implementation(projects.feature.home.domain)
    implementation(projects.feature.home.modelui)
    implementation(projects.feature.home.panes)
}
