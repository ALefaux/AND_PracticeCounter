import com.android.build.api.dsl.ApplicationExtension
import fr.alefaux.buildlogic.configureAndroidCompose
import fr.alefaux.buildlogic.extensions.alias
import fr.alefaux.buildlogic.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                alias(libs.findPlugin("kotlin-compose").get())
            }
            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }
}
