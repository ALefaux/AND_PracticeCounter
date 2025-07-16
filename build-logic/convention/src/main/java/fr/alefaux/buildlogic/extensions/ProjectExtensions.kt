package fr.alefaux.buildlogic.extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderConvertible
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? = add("implementation", dependencyNotation)

// Version
val VersionCatalog.androidMinSdkVersion: Int
    get() = findVersion("androidMinSdk").get().toString().toInt()

val VersionCatalog.androidTargetSdkVersion: Int
    get() = findVersion("androidTargetSdk").get().toString().toInt()

val VersionCatalog.androidCompileSdkVersion: Int
    get() = findVersion("androidCompileSdk").get().toString().toInt()

fun PluginManager.alias(notation: Provider<PluginDependency>) {
    apply(notation.get().pluginId)
}

fun PluginManager.alias(notation: ProviderConvertible<PluginDependency>) {
    apply(notation.asProvider().get().pluginId)
}
