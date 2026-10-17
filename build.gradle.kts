// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.60.1")

     //   classpath(libs.plugins.hilt.android)

    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.apollographql.apollo") version "5.2.0"
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt.android) apply false

}