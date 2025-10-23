plugins {
    alias(libs.plugins.practicecounter.panes)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.home.panes"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.feature.home.modelui)
    implementation(projects.feature.home.ui)
}
