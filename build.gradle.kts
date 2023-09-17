// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.AGP.application) version Versions.AGP apply false
    id(Plugins.AGP.library) version Versions.AGP apply false
    kotlin(Plugins.Kotlin.android) version Versions.kotlin apply false
    kotlin(Plugins.Kotlin.jvm) version Versions.kotlin apply false
    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs) version Versions.navigation apply false

    // Hilt
    id(Plugins.Hilt.android) version Versions.dagger apply false
}