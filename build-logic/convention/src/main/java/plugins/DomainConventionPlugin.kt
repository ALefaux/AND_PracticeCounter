package plugins

import fr.alefaux.buildlogic.configureModule
import fr.alefaux.buildlogic.extensions.libs
import fr.alefaux.buildlogic.plugins.RocketDomainConventionPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class DomainConventionPlugin : RocketDomainConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            pluginManager.apply {
                apply("com.android.library")
            }
        }
    }
}
