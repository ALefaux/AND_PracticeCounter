package plugins

import fr.alefaux.buildlogic.plugins.RocketUiConventionPlugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class UIConventionPlugin : RocketUiConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }

            dependencies {
                add("implementation", project(":core:designsystem"))
            }
        }
    }
}
