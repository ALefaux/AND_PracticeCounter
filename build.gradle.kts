// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}

// Configuration to resolve Rocket version
val rocketVersionResolution by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
}

dependencies {
    rocketVersionResolution(libs.rocket.convention)
}

// Display Rocket version on each build
gradle.projectsEvaluated {
    val resolvedVersion = rocketVersionResolution.resolvedConfiguration.firstLevelModuleDependencies
        .find { it.moduleGroup == "fr.alefaux.rocket" && it.moduleName == "convention" }
        ?.moduleVersion

    if (resolvedVersion != null) {
        println("🚀 Rocket version: $resolvedVersion")
    }
}
