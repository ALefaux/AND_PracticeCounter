import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "fr.alefaux.practicecounter.build_logic.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "practicecounter.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "practicecounter.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "practicecounter.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("dataLocal") {
            id = "practicecounter.data.local"
            implementationClass = "plugins.DataLocalConventionPlugin"
        }
        register("dataRemote") {
            id = "practicecounter.data.remote"
            implementationClass = "plugins.DataRemoteConventionPlugin"
        }
        register("di") {
            id = "practicecounter.di"
            implementationClass = "plugins.DiConventionPlugin"
        }
        register("domain") {
            id = "practicecounter.domain"
            implementationClass = "plugins.DomainConventionPlugin"
        }
        register("modelUiLocal") {
            id = "practicecounter.model.ui"
            implementationClass = "plugins.ModelUIConventionPlugin"
        }
        register("panes") {
            id = "practicecounter.panes"
            implementationClass = "plugins.PanesConventionPlugin"
        }
        register("presentation") {
            id = "practicecounter.presentation"
            implementationClass = "plugins.PresentationConventionPlugin"
        }
        register("ui") {
            id = "practicecounter.ui"
            implementationClass = "plugins.UIConventionPlugin"
        }
    }
}