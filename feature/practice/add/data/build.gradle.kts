plugins {
    alias(libs.plugins.practicecounter.data.local)
}

android {
    namespace = "fr.alefaux.practicecounter.feature.add.data"
}

dependencies {
    implementation(projects.core.storage)
}
