// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    val agpVersion by extra("7.1.2")
    dependencies {
        classpath("com.android.tools.build:gradle:$agpVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

// sync from https://github.com/LSPosed/LSPosed/blob/master/build.gradle.kts
val defaultManagerPackageName by extra("org.lsposed.lspatch")
val apiCode by extra(93)
val verCode by extra(1)
val verName by extra("0.3")
val androidMinSdkVersion by extra(28)
val androidTargetSdkVersion by extra(32)
val androidCompileSdkVersion by extra(32)
val androidCompileNdkVersion by extra("23.1.7779620")
val androidBuildToolsVersion by extra("31.0.0")
val androidSourceCompatibility by extra(JavaVersion.VERSION_11)
val androidTargetCompatibility by extra(JavaVersion.VERSION_11)

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

listOf("Debug", "Release").forEach { variant ->
    tasks.register("build$variant") {
        description = "Build LSPatch with $variant"
        dependsOn(projects.patchJar.dependencyProject.tasks["build$variant"])
        dependsOn(projects.manager.dependencyProject.tasks["build$variant"])
    }
}
