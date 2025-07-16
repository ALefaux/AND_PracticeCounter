plugins {
    alias(libs.plugins.practicecounter.ui)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.home.ui"
}

dependencies {
    implementation(projects.core.designsystem)
}
