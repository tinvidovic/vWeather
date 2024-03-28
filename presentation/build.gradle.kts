plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.assignments.vweather.presentation"
}

dependencies {
    implementation(project(Modules.domain))
}