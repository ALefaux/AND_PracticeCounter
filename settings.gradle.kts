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
        mavenLocal()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "Practice-Counter"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")

// Core
include(
    ":core:designsystem",
    ":core:components",
    ":core:localisation",
    ":core:model",
    ":core:navigation",
    ":core:storage",
    ":core:utils"
)

// Practice list
include(
    ":feature:practice:list:data",
    ":feature:practice:list:domain",
    ":feature:practice:list:di",
    ":feature:practice:list:ui",
    ":feature:practice:list:panes",
    ":feature:practice:list:model-ui",
    ":feature:practice:list:presentation",
)

// Home
include(
    ":feature:home:data",
    ":feature:home:domain",
    ":feature:home:di",
    ":feature:home:modelui",
    ":feature:home:panes",
    ":feature:home:presentation",
    ":feature:home:ui",
)

// Practice add
include(
    ":feature:practice:add:data",
    ":feature:practice:add:domain",
    ":feature:practice:add:di",
    ":feature:practice:add:modelui",
    ":feature:practice:add:panes",
    ":feature:practice:add:presentation",
    ":feature:practice:add:ui",
)

// Practice detail
include(
    ":feature:practice:detail:data",
    ":feature:practice:detail:domain",
    ":feature:practice:detail:di",
    ":feature:practice:detail:modelui",
    ":feature:practice:detail:panes",
    ":feature:practice:detail:presentation",
    ":feature:practice:detail:ui",
)
