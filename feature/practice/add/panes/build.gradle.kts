plugins {
    alias(libs.plugins.practicecounter.panes)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.add.panes"
}

dependencies {
    implementation(projects.core.designsystem)

    implementation(projects.feature.practice.add.modelui)
    implementation(projects.feature.practice.add.ui)
}
