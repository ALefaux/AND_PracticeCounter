package plugins

import fr.alefaux.buildlogic.plugins.RocketPanesConventionPlugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class PanesConventionPlugin : RocketPanesConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }

            dependencies {
                add("implementation", project(":core:components"))
                add("implementation", project(":core:designsystem"))
            }
        }
    }
}
