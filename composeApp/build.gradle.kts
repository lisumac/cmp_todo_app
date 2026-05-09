import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.serialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            // This is where preview tooling belongs
            implementation(libs.compose.uiToolingPreview)

            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
            implementation(libs.sqldelight.android)
            implementation(libs.navigation.compose)
            implementation(libs.navigation3.runtime)
            implementation(libs.navigation3.ui)
            implementation(libs.navigation3.viewmodel)
            implementation(libs.navigation3.adaptive)
        }

        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)

            // REMOVED: implementation(libs.compose.uiToolingPreview)
            // Previews in commonMain are not supported for iOS targets yet.

            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.kotlinx.serialization)
            implementation(libs.kotlinx.date.time)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.navigation3)
            implementation(libs.compose.uiToolingPreview)
        }

        iosMain.dependencies {
            // Add iOS specific dependencies here if needed
            implementation(libs.sqldelight.ios)
           // implementation(libs.navigation2)
        }
    }
}

android {
    namespace = "org.rdk.todo"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.rdk.todo"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.compose.uiTooling)
}
sqldelight {
    databases {
        create("MyDatabase") { // You can rename "MyDatabase" to whatever you like
            packageName.set("org.rdk.todo.db") // This is where your code will be generated
        }
    }
}