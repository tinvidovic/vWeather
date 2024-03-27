plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.assignment.vweather"
}

dependencies {
    implementation(project(Modules.domain))
}