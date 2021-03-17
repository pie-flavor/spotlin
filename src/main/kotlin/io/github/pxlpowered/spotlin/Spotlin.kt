/*
 * This file is part of Spotlin, licensed under the MIT License (MIT). See the LICENSE file
 * at the root of this project for more details.
 */

package io.github.pxlpowered.spotlin

import com.google.inject.Inject
import org.slf4j.Logger
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GamePreInitializationEvent
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.plugin.PluginContainer

@Suppress("UNUSED_PARAMETER")
@Plugin(
    id = "spotlin",
    name = "Spotlin",
    version = "0.2.0",
    description = "Provides the Kotlin runtime for other plugins."
)
class Spotlin @Inject constructor(
    private val pluginContainer: PluginContainer,
    private val logger: Logger
) {
    @Listener
    fun onPreInit(e: GamePreInitializationEvent) {
        logger.info(
            "Running {} v{}",
            pluginContainer.name,
            pluginContainer.version.orElse(null) ?: "unknown"
        )
        logger.info("        Kotlin v1.4.31")
    }
}
