plugins {
    alias(libs.plugins.practicecounter.data.local)
    alias(libs.plugins.practicecounter.android.hilt)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.practice.add.data"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.storage)
    implementation(projects.feature.practice.add.domain)
}
