package plugins

import fr.alefaux.buildlogic.plugins.RocketModelUiConventionPlugin
import org.gradle.api.Project

@Suppress("unused")
class ModelUIConventionPlugin : RocketModelUiConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }
        }
    }
}
