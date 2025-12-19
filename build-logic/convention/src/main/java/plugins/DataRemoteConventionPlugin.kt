package plugins

import fr.alefaux.buildlogic.configureModule
import fr.alefaux.buildlogic.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DataRemoteConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jlleitschuh.gradle.ktlint")
                apply("kotlinx-serialization")
            }

            configureModule()

            dependencies {
                add("implementation", libs.findLibrary("squareup.okhttp.logging").get())
                add("implementation", platform(libs.findLibrary("squareup-retrofit-bom").get()))
                add("implementation", libs.findLibrary("squareup.retrofit.core").get())
                add("implementation", libs.findLibrary("squareup.retrofit.rxjava").get())
                add("implementation", libs.findLibrary("kotlinx.serialization.json").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
                add("implementation", libs.findLibrary("jakewharton.timber").get())
            }
        }
    }
}
