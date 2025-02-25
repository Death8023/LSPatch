val androidSourceCompatibility: JavaVersion by rootProject.extra
val androidTargetCompatibility: JavaVersion by rootProject.extra

plugins {
    id("java-library")
}

java {
    sourceCompatibility = androidSourceCompatibility
    targetCompatibility = androidTargetCompatibility
}

dependencies {
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("org.bouncycastle:bcpkix-jdk15on:1.70")
    implementation("org.bouncycastle:bcprov-jdk15on:1.70")
    api("com.google.guava:guava:31.0.1-jre")
    api("com.android.tools.build:apksig:7.1.1")
    compileOnlyApi("com.google.auto.value:auto-value-annotations:1.9")
    annotationProcessor("com.google.auto.value:auto-value:1.9")
}
