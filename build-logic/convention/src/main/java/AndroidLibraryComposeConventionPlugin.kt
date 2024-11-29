import com.android.build.api.dsl.LibraryExtension
import fr.alefaux.practicecounter.build_logic.convention.alias
import fr.alefaux.practicecounter.build_logic.convention.configureAndroidCompose
import fr.alefaux.practicecounter.build_logic.convention.implementation
import fr.alefaux.practicecounter.build_logic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                alias(libs.findPlugin("kotlin-compose").get())
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

            dependencies {
                implementation(libs.findLibrary("androidx-lifecycle-viewmodel-compose").get())
            }
        }
    }
}