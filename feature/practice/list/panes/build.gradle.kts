plugins {
    alias(libs.plugins.practicecounter.panes)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.list.panes"
}

dependencies {
    implementation(projects.core.designsystem)

    implementation(projects.feature.practice.list.ui)
    implementation(projects.feature.practice.list.modelUi)
}
