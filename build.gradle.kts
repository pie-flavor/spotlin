plugins {
    eclipse
    idea
    id("com.github.johnrengelman.shadow") version "5.1.0"
    id("net.minecrell.licenser") version "0.3"
    kotlin("jvm") version "1.3.40"
    kotlin("kapt") version "1.3.40"
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
    jcenter()
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    maven {
        url = uri("https://repo.spongepowered.org/maven/")
    }
}

dependencies {
    val sponge = create("org.spongepowered:spongeapi:$spongeVersion")
    api(sponge)
    kapt(sponge)
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

license {
    header = project.file("HEADER")
    include("**/*.kt")
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    includeCompileClasspath = false
}

artifacts {
    archives(tasks.shadowJar.get())
}

tasks.signArchives {
    dependsOn(tasks.shadowJar.get())
}
