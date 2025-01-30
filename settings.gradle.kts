pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Practice-Counter"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:designsystem")

// Practice list
include(
    ":feature:practice:list:ui",
    ":feature:practice:list:panes",
    ":feature:practice:list:model-ui",
    ":feature:practice:list:presentation"
)

// Home
include(
    ":feature:home:presentation",
    ":feature:home:panes",
    ":feature:home:ui"
)

// Practice add
include(
    ":feature:practice:add:ui",
    ":feature:practice:add:panes",
    ":feature:practice:add:presentation",
    ":feature:practice:add:data"
)
include(":core:storage")
