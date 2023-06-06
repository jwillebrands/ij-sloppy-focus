package dev.willebrands.intellij.sloppyfocus.util

import com.intellij.openapi.diagnostic.Logger

private const val pluginCategory = "dev.willebrands.intellij.sloppyfocus"
private val componentLoggers = mutableMapOf<String, Logger>()

val pluginLogger: Logger by lazy {
    Logger.getInstance(pluginCategory)
}

fun componentLogger(component: String): Logger = componentLoggers.computeIfAbsent(
    component
) { Logger.getInstance("$pluginCategory.$component") }
