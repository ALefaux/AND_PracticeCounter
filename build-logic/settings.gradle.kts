dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
        create("rocket") {
            from("fr.alefaux.rocket:versioning:0.1.+")
        }
    }
}

rootProject.name = "build-logic"
include(":convention")
