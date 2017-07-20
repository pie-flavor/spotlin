package io.github.pxlpowered.spotlin.spigot

import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import java.util.logging.Logger

class Spotlin: JavaPlugin() {

    override fun onLoad() {
        logger.info("=====================")
        logger.info("Using {} v{}, providing kotlin v{}", "Spotlin", "0.1.0-SNAPSHOT", "1.1.3")
        logger.info("=====================")
    }
}

private fun Logger.info(message: String, vararg args: String) {
    var transformed = message.replace("{}", "%s")
    var buf = StringBuilder()
    val fmt = Formatter(buf)
    fmt.format(transformed, args)
    info(buf.toString())
}
