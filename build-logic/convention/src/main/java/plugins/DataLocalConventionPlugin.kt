package plugins

import fr.alefaux.buildlogic.configureModule
import fr.alefaux.buildlogic.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DataLocalConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jlleitschuh.gradle.ktlint")
                apply("com.google.devtools.ksp")
            }

            configureModule()

            dependencies {
                add("implementation", libs.findLibrary("androidx.room.common").get())
                add("ksp", libs.findLibrary("androidx.room.compiler").get())
                add("implementation", libs.findLibrary("androidx.room.ktx").get())
                add("implementation", libs.findLibrary("androidx.room.runtime").get())
                add("implementation", libs.findLibrary("androidx.room.rxjava").get())
                add("implementation", libs.findLibrary("androidx.datastore").get())
                add("implementation", libs.findLibrary("androidx.datastore.preferences").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.rx3").get())
            }
        }
    }
}
