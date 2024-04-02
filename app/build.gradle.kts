plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.assignments.vweather"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "com.assignments.vweather.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // NOTE: In actual production app should never use debug signing config
            signingConfig = signingConfigs.getByName("debug")
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
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleViewModel)

    // Dagger-Hilt
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)

    // Timber
    implementation(Timber.timber)

    // Jetpack Compose
    implementation(platform(Compose.composeBoM))
    implementation(Compose.composeActivity)
    implementation(Compose.composeUi)
    implementation(Compose.composeGraphics)
    implementation(Compose.composeFoundations)
    implementation(Compose.composeMaterial3)
    implementation(Compose.composeUiToolingPreview)
    implementation(Compose.composeViewModel)
    debugImplementation(Compose.composeUiTooling)

    // Moshi
    implementation(Moshi.moshi)
    kapt(Moshi.moshiCodegen)

    // Modules
    implementation(project(Modules.data))
    implementation(project(Modules.domain))
    implementation(project(Modules.presentation))

    // Testing
    testImplementation(Testing.junit4)
    testImplementation(Testing.junitAndroidExt)
    testImplementation(Testing.coroutines)
    testImplementation(Testing.truth)
    testImplementation(Testing.composeUiTest)
    testImplementation(Testing.hiltTesting)
    testImplementation(Testing.testRunner)

    androidTestImplementation(Testing.junit4)
    androidTestImplementation(Testing.junitAndroidExt)
    androidTestImplementation(Testing.coroutines)
    androidTestImplementation(Testing.truth)
    androidTestImplementation(Testing.composeUiTest)
    androidTestImplementation(Testing.hiltTesting)
    androidTestImplementation(Testing.testRunner)
    kaptAndroidTest(DaggerHilt.hiltCompiler)

}