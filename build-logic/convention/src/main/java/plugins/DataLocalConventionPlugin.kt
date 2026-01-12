package plugins

import fr.alefaux.buildlogic.plugins.RocketDataLocalConventionPlugin
import org.gradle.api.Project

@Suppress("unused")
class DataLocalConventionPlugin : RocketDataLocalConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }
        }
    }
}
