// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.46" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}
// Root build.gradle.kts (project-level)
buildscript {
    val kotlinVersion by extra("1.9.0")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.gradle)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath(libs.hilt.android.gradle.plugin)
    }
}
