plugins {
    java
    kotlin("jvm") version "1.3.72"
    `maven-publish`
}

group = "tech.dsstudio"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "tech.dsstudio"
            artifactId = "RandomGenerator"
            version = "0.1-SNAPSHOT"

            from(components["kotlin"])
        }
    }
}
