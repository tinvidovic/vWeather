object DaggerHilt {
    const val version = "2.51"
    const val hiltAndroid = "com.google.dagger:hilt-android:$version"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"

    private const val hiltNavigationComposeVersion = "1.2.0"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
}