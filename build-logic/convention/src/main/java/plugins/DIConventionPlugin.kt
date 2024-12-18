package plugins

import fr.alefaux.buildlogic.configureModule
import fr.alefaux.buildlogic.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DIConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jlleitschuh.gradle.ktlint")
                apply("decathlon.android.test")
            }

            configureModule()

            dependencies {
                add("implementation", libs.findBundle("koin").get())
                add("implementation", libs.findLibrary("koin.compose").get())
                add("implementation", libs.findBundle("koin.test.junit").get())
                add("testImplementation", libs.findLibrary("koin.test").get())
            }
        }
    }
}
