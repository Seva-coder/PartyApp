plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    //DI
    implementation(libs.koin.core)
    testImplementation(libs.koin.test)

    //Testing
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}