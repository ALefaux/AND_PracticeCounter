plugins {
    alias(libs.plugins.practicecounter.data.local)
    alias(libs.plugins.practicecounter.android.hilt)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.home.data"
}

dependencies {
    implementation(projects.core.storage)
}
