import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl` // Access Gradle DSL functionality
}

repositories {
    google()
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    // NOTE: Version should match version specified in the /Build.kt file
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    implementation("com.android.tools.build:gradle:8.2.2")
    // Dagger-Hilt dependency issue, see https://github.com/google/dagger/issues/3068
    implementation("com.squareup:javapoet:1.13.0")
}


val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}