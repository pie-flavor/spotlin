package io.github.pxlpowered.spotlin.sponge

import com.google.inject.Inject
import org.slf4j.Logger
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GameLoadCompleteEvent
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.plugin.PluginContainer

@Plugin(id = "spotlin")
class Spotlin @[Inject] constructor(val container: PluginContainer,
        val logger: Logger) {

    @[Listener]
    fun onGameStarted(event: GameLoadCompleteEvent) {
        logger.info("=====================")
        logger.info("Using {} v{}, providing kotlin v{}",
                container.name,
                (if (container.version.isPresent)
                    container.version.get()
                else
                    "unknown"),
                "1.1.3")
        logger.info("=====================")
    }
}