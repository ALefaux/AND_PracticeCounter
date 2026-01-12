package plugins

import fr.alefaux.buildlogic.plugins.RocketCoreConventionPlugin
import org.gradle.api.Project

@Suppress("unused")
class CoreConventionPlugin : RocketCoreConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }
        }
    }
}