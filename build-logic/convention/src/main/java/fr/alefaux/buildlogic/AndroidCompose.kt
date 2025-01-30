package fr.alefaux.buildlogic

import com.android.build.api.dsl.CommonExtension
import fr.alefaux.buildlogic.extensions.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    with(pluginManager) {
        val composeCompilerId =
            libs
                .findPlugin("kotlin-compose")
                .get()
                .get()
                .pluginId
        apply(composeCompilerId)
    }

    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        packaging {
            resources {
                excludes += "META-INF/LICENSE.md"
                excludes += "META-INF/LICENSE-notice.md"
            }
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("debugImplementation", platform(bom))
            add("implementation", libs.findLibrary("androidx.compose.material3").get())
            add("implementation", libs.findLibrary("androidx.compose.ui.tooling").get())
            add("implementation", libs.findLibrary("androidx.compose.ui.tooling.preview").get())
        }
    }
}
