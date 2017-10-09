# Spotlin

A [Sponge](https://spongepowered.org) plugin providing the [Kotlin](https://kotlinlang.org/) runtime, standard library,
and reflection library to other plugins. 

### License

Licensed under the [MIT License](http://opensource.org/licenses/MIT).

## Depending on Spotlin - Build System

Follow the instructions below to depend on kotlin.

- [Gradle](https://kotlinlang.org/docs/reference/using-gradle.html)
- [Maven](https://kotlinlang.org/docs/reference/using-maven.html)

## Depending on Spotlin - Plugin Manifest

In order to make sure your plugin both requires and loads after Spotlin, add this to your `@Plugin` annotation:
```kotlin
@[Plugin(dependencies = arrayOf(Dependency(id = "spotlin", 
                                           optional = false, 
                                           version = "0.1.3")))]
class PluginClass
```

If you do not have the `kapt` plugin enabled, you will also need to add this to your `mcmod.info` file:
```json
{
    "requiredMods": [
        "spotlin@0.1.3"
    ]
}
```