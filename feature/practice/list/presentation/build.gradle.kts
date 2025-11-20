plugins {
    alias(libs.plugins.practicecounter.presentation)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.list.presentation"
}

dependencies {
    implementation(projects.core.components)
    implementation(projects.core.navigation)
    implementation(projects.core.utils)

    implementation(projects.feature.practice.list.domain)
    implementation(projects.feature.practice.list.modelUi)
    implementation(projects.feature.practice.list.panes)
}
