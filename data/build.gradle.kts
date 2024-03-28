plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.assignments.vweather.data"
}

dependencies {
    implementation(project(Modules.domain))
}