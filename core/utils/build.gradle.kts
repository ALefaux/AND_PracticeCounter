plugins {
    alias(libs.plugins.practicecounter.core)
}

android {
    namespace = "fr.alefaux.practicecounter.core.utils"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}