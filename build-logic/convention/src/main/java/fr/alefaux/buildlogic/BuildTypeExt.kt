package fr.alefaux.buildlogic

import com.android.build.api.dsl.ApplicationBuildType
import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import java.io.File

val isDebugBuild = System.getenv("CI") == null

fun ApplicationBuildType.enableMinification(project: Project) {
    enableUnitTestCoverage = false
    isShrinkResources = true
    isMinifyEnabled = true
    isDebuggable = false

    project.extensions.getByType(BaseExtension::class.java).apply {
        proguardFile(getDefaultProguardFile("proguard-android.txt"))
    }
    proguardFile(File(project.projectDir, "proguard/proguard-rules.pro"))
    proguardFile(File(project.projectDir, "proguard/proguard-medallia.pro"))
    proguardFile(File(project.projectDir, "proguard/proguard-vitamin-play.pro"))
    proguardFile(File(project.projectDir, "proguard/proguard-navigation.pro"))
    proguardFile(File(project.projectDir, "proguard/proguard-s2s.pro"))
}
