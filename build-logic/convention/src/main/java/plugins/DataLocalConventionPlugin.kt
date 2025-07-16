package plugins

import fr.alefaux.buildlogic.configureModule
import org.gradle.api.Plugin
import org.gradle.api.Project

class DataLocalConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }

            configureModule()
        }
    }
}
