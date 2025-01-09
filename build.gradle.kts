plugins {
    idea
    `java-library`
    alias(libs.plugins.hibernate)
}

repositories {
    mavenCentral()
}

tasks {
    compileJava {
        sourceCompatibility = "21"
        targetCompatibility = "21"
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

dependencies {
    annotationProcessor(libs.hibernate.jpamodelgen)
    implementation(libs.hibernate)

    // Testing
    testImplementation(libs.h2)
    testImplementation(libs.reflection)
    testImplementation(libs.junit5)
}
