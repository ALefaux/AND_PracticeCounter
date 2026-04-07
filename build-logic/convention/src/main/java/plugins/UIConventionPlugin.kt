package plugins

import com.android.build.gradle.LibraryExtension
import fr.alefaux.buildlogic.configureAndroidCompose
import fr.alefaux.buildlogic.configureModule
import fr.alefaux.buildlogic.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

@Suppress("unused")
class UIConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            configureModule()

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

            dependencies {
                add("implementation", project(":core:designsystem"))

                add("implementation", libs.findLibrary("androidx.compose.material.core").get())
                add("implementation", libs.findLibrary("androidx.compose.material.extended").get())
            }
        }
    }
}
