import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    idea
    `java-library`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.noarg)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.kotlin.allopen)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.hibernate)
    alias(libs.plugins.ktlint)
}

repositories {
    mavenCentral()
}

ktlint {
    version.set(libs.versions.ktlint)
}

tasks {
    compileJava {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    compileKotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xskip-prerelease-check")
        }
    }

    test {
        useJUnitPlatform()
        jvmArgs(listOf("-XX:+EnableDynamicAgentLoading"))
    }
}

hibernate {
    enhancement {
        enableLazyInitialization.set(true)
        enableDirtyTracking.set(true)
        enableAssociationManagement.set(true)
        enableExtendedEnhancement.set(true)
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

noArg {
    annotation("jakarta.persistence.Entity")
    annotation("lombok.NoArgsConstructor")
    invokeInitializers = true
}

dependencies {
    kapt(libs.hibernate.jpamodelgen)
    implementation(libs.hibernate)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.noarg)
    implementation(libs.kotlin.stdlib.jdk8)
    implementation(libs.lombok.annotations)
    implementation(libs.bundles.spring.boot)
    implementation(libs.lombok.annotations)

    // Testing
 //   testImplementation(libs.kotlin.test)
 //   testImplementation(libs.kotest)
 //   testImplementation(libs.hamcrest)
    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.h2)
}

