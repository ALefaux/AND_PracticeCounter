plugins {
    alias(libs.plugins.practicecounter.core)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "fr.alefaux.practicecounter.core.navigation"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(projects.core.components)
    implementation(projects.core.designsystem)
    implementation(projects.core.localisation)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.adaptive.navigation.suite)
    implementation(libs.androidx.compose.material.core)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.hilt.navigation.compose)

    implementation(libs.androidx.core.ktx)
}