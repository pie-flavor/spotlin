# Spotlin

A [Sponge](https://spongepowered.org) plugin providing the [Kotlin](https://kotlinlang.org/) runtime, standard library,
and reflection library to other plugins. 

### License

Licensed under the [MIT License](http://opensource.org/licenses/MIT).

## Depending on Spotlin - Build System

### Gradle

First, ensure you have the Kotlin gradle plugin enabled.
```gradle
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.3'
    }
}
apply plugin: 'kotlin'
```

or

```gradle
plugins {
    id "org.jetbrains.kotlin.jvm" version "1.1.3"
}
```

Next, add the [JitPack](https://jitpack.io) repository:

```gradle
repositories {
    maven {
        url 'https://jitpack.io/'
    }
}
```

Last, add a dependency on Spotlin:

```gradle
dependencies {
    compile 'com.github.pxlpowered:Spotlin:0.1.0'
}
```

### Maven

First, ensure you have the Kotlin Maven plugin enabled:

```xml
<build>
    <plugins>
        <plugin>
            <artifactId>kotlin-maven-plugin</artifactId>
            <groupId>org.jetbrains.kotlin</groupId>
            <version>${kotlin.version}</version>

            <executions>
                <execution>
                    <id>compile</id>
                    <goals> <goal>compile</goal> </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

Second, add the [JitPack](https://jitpack.io) repository:

```xml
<repositories>
    <repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Last, add a dependency on Spotlin:

```xml
<dependencies>
    <dependency>
        <groupId>com.github.pxlpowered</groupId>
        <artifactId>Spotlin</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```

## Depending on Spotlin - Plugin Manifest

In order to make sure your plugin both requires and loads after Spotlin, add this to your `@Plugin` annotation:
```kotlin
@[Plugin(dependencies = arrayOf(Dependency(id = "spotlin", 
                                           optional = false, 
                                           version = "0.1.0")))]
class PluginClass
```

If you do not have the `kapt` plugin enabled, you will also need to add this to your `mcmod.info` file:
```json
{
    "requiredMods": [
        "spotlin@0.1.0"
    ]
}
```