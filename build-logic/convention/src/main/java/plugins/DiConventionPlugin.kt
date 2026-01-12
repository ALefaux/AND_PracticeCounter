package plugins

import fr.alefaux.buildlogic.plugins.RocketDiConventionPlugin
import org.gradle.api.Project

@Suppress("unused")
class DiConventionPlugin : RocketDiConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }
        }
    }
}
