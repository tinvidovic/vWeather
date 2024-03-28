plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.assignments.vweather.data"
}

dependencies {
    implementation(project(Modules.domain))

    // Retrofit with OkHttp
    implementation(Retrofit.okHttp)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.okHttpLoggingInterceptor)
    implementation(Retrofit.moshiConverter)

    // Moshi
    implementation(Moshi.moshi)
}