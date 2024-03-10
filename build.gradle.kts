import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.github.l1an"
version = "0.4.2"

repositories {
    maven("https://jitpack.io")
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://libraries.minecraft.net/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.codemc.io/repository/maven-snapshots/")
    maven("https://repo.opencollab.dev/maven-snapshots/")
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("com.github.gabber235:typewriter:main-SNAPSHOT")

    compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    compileOnly("com.github.dyam0:LirandAPI:96cc59d4fb")
    compileOnly("net.kyori:adventure-api:4.13.1")
    compileOnly("net.kyori:adventure-text-minimessage:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    withType<Jar> {
        destinationDirectory.set(file("$projectDir/build-jar"))
        archiveFileName.set("YuIllustrationAdapter-${project.version}.jar")
    }
}