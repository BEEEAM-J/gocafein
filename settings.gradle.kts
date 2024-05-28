pluginManagement {
    repositories {
        google()
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

rootProject.name = "gocafein"
include(":data")
include(":domain")
include(":presentation")
include(":presentation:search")
include(":presentation:detail")
include(":presentation:navigator")
include(":app")
