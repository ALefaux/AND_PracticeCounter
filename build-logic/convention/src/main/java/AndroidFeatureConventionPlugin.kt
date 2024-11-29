import fr.alefaux.practicecounter.build_logic.convention.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("practicecounter.android.library")
                apply("practicecounter.android.hilt")
            }

            dependencies {
                implementation(project(":core:designsystem"))
            }
        }
    }
}