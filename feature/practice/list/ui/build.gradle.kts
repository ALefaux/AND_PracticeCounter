plugins {
    alias(libs.plugins.practicecounter.ui)
}

android {
    namespace = "fr.alefaux.practicecounter.practice.ui"
}

dependencies {
    implementation(projects.core.designsystem)
}
