package plugins

import com.android.build.gradle.LibraryExtension
import fr.alefaux.buildlogic.configureAndroidCompose
import fr.alefaux.buildlogic.configureModule
import fr.alefaux.buildlogic.extensions.implementation
import fr.alefaux.buildlogic.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

@Suppress("unused")
class PresentationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("dagger.hilt.android.plugin")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<LibraryExtension> {
                configureModule()
            }

            kotlinExtension.sourceSets.all {
                languageSettings.enableLanguageFeature("ExplicitBackingFields")
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

            dependencies {
                add("implementation", project(":core:components"))
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:model"))
                add("implementation", project(":core:navigation"))

                add("implementation", libs.findLibrary("androidx.compose.material3").get())
                add("implementation", libs.findLibrary("androidx.compose.ui").get())
                add("implementation", libs.findLibrary("androidx.compose.ui.graphics").get())
                add("implementation", libs.findLibrary("androidx.compose.ui.tooling").get())
                add("implementation", libs.findLibrary("androidx.compose.ui.tooling.preview").get())
                add(
                    "implementation",
                    libs.findLibrary("androidx.lifecycle.viewmodel.compose").get()
                )
                add("implementation", libs.findLibrary("kotlinx.collections.immutable").get())
                add("debugImplementation", libs.findLibrary("androidx.compose.manifest").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())

                implementation(libs.findLibrary("hilt-android").get())
                implementation(libs.findLibrary("hilt-navigation-compose").get())
                "ksp"(libs.findLibrary("hilt-compiler").get())

                implementation(libs.findLibrary("jakewharton-timber").get())
            }
        }
    }
}
