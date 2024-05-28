plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")

    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.beeeam.navigator"
    compileSdk = Configuration.COMPILE_SDK

    defaultConfig {
        minSdk = Configuration.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":presentation:detail"))
    implementation(project(":presentation:search"))

    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.LIFECYCLE_RUNTIME)

    implementation(AndroidX.ACTIVITY_COMPOSE)
    implementation(AndroidX.COMPOSE_BOM)
    implementation(AndroidX.COMPOSE_UI)
    implementation(AndroidX.COMPOSE_UI_GRAPHICS)
    implementation(AndroidX.COMPOSE_PREVIEW)
    implementation(AndroidX.COMPOSE_MATERIAL)

    testImplementation(AndroidX.JUNIT)
    androidTestImplementation(AndroidX.EXT_JUNIT)
    androidTestImplementation(AndroidX.ESPRESSO_CORE)

    androidTestImplementation(platform(AndroidX.COMPOSE_BOM))
    androidTestImplementation(AndroidX.COMPOSE_UI_JUNIT)
    debugImplementation(AndroidX.COMPOSE_UI_TOOLING)
    debugImplementation(AndroidX.COMPOSE_UI_TEST_MANIFEST)

    implementation(Google.HILT_ANDROID)
    kapt(Google.HILT_ANDROID_COMPILER)

    implementation(Google.MATERIAL)

    implementation(Orbit.ORBIT_VIEWMODEL)
    implementation(Orbit.ORBIT_COMPOSE)
}