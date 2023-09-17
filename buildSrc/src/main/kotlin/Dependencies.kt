object Versions {

    const val AGP = "8.1.1"
    const val kotlin = "1.8.21"
    const val coroutines = "1.7.1"
    const val KSP = "1.8.21-1.0.11"
    const val material = "1.9.0"
    const val constraintLayout = "2.1.4"
    const val vbpd = "1.5.9"
    const val core = "1.10.1"
    const val splashscreen = "1.0.1"
    const val activity = "1.7.2"
    const val coil = "2.2.2"
    const val fragment = "1.5.7"
    const val lifecycle = "2.6.1"
    const val navigation = "2.5.3"
    const val dagger = "2.46.1"
    const val viewPager2 = "1.0.0"
    const val retrofit = "2.9.0"
    const val okHttp = "5.0.0-alpha.11"
    const val paging = "3.1.1"
    const val json = "2.9.1"
}

object Libraries {

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${
            Versions.coroutines
        }"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${
            Versions.coroutines
        }"
    }

    object UIComponents {
        const val material = "com.google.android.material:material:${
            Versions.material
        }"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${
            Versions.constraintLayout
        }"
        const val vbpd = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${
            Versions.vbpd
        }"
    }

    object Core {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val splashscreen = "androidx.core:core-splashscreen:${Versions.splashscreen}"
    }

    object Activity {
        const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    }

    object Fragment {
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val service = "androidx.lifecycle:lifecycle-service:${Versions.lifecycle}"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"

        const val hiltnavigation = "androidx.hilt:hilt-navigation-fragment:1.0.0"
    }

    object ViewPager {
        const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Coil {
        const val coil = "io.coil-kt:coil:${Versions.coil}"
        const val svg = "io.coil-kt:coil-svg:${Versions.coil}"
    }

    object OkHttp {
        const val bom = "com.squareup.okhttp3:okhttp-bom:${Versions.okHttp}"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    }


    object Paging {
        const val runtime = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
        const val common = "androidx.paging:paging-common:${Versions.paging}"
    }
}

object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "android"
        const val jvm = "jvm"
        const val kapt = "kapt"
    }

    object KSP {
        const val ksp = "com.google.devtools.ksp"
    }

    object Navigation {
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
    }

    object Hilt {
        const val android = "com.google.dagger.hilt.android"
    }
}