import org.spongepowered.gradle.plugin.config.PluginLoaders
import org.spongepowered.plugin.metadata.model.PluginDependency

plugins {
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("org.spongepowered.gradle.plugin") version "1.1.1"
    id("flavor.pie.promptsign") version "1.1.0"
}

val spongeVersion: String by project
val kotlinVersion: String by project
val pluginGroup: String by project
val pluginVersion: String by project

group = pluginGroup
version = pluginVersion

repositories {
    mavenCentral()
}

sponge {
    apiVersion("8.0.0-SNAPSHOT")
    license("https://github.com/pie-flavor/spotlin/blob/master/LICENSE")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("spotlin") {
        displayName("Spotlin")
        entrypoint("io.github.pxlpowered.spotlin.Spotlin")
        version(project.version as String?)
        description("Provides the Kotlin runtime for other plugins.")
        links {
            homepage("https://github.com/pie-flavor/spotlin")
            source("https://github.com/pie-flavor/spotlin")
            issues("https://github.com/pie-flavor/spotlin/issues")
        }
        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
    }
}

dependencies {
    val stdlib = create(kotlin("stdlib-jdk8"))
    api(stdlib)
    shadow(stdlib)
    val reflect = create(kotlin("reflect"))
    api(reflect)
    shadow(reflect)
    val coroutines = create("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.3.0-M2")
    api(coroutines)
    shadow(coroutines)
    val serialization = create("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")
    api(serialization)
    shadow(serialization)
}

tasks.shadowJar {
    archiveBaseName.set("${project.name}-$spongeVersion-$kotlinVersion")
    configurations = listOf(project.configurations.shadow.get())
    archiveClassifier.set("")
}

tasks.jar {
    enabled = false
}

tasks.build {
    dependsOn(tasks.shadowJar.get())
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

artifacts {
    archives(tasks.shadowJar.get())
}

tasks.signArchives {
    dependsOn(tasks.shadowJar.get())
}
