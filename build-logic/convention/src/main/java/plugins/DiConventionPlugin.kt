package plugins

import fr.alefaux.buildlogic.configureModule
import fr.alefaux.buildlogic.extensions.implementation
import fr.alefaux.buildlogic.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class DiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")
                apply("dagger.hilt.android.plugin")
            }

            configureModule()

            dependencies {
                implementation(libs.findLibrary("hilt-android").get())
                implementation(libs.findLibrary("hilt-navigation-compose").get())
                "ksp"(libs.findLibrary("hilt-compiler").get())
            }
        }
    }
}
