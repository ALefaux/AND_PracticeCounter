package plugins

import fr.alefaux.buildlogic.plugins.RocketDataRemoteConventionPlugin
import org.gradle.api.Project

@Suppress("unused")
class DataRemoteConventionPlugin : RocketDataRemoteConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }
        }
    }
}
