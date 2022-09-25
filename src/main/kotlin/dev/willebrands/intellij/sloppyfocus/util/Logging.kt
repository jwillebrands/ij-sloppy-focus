package dev.willebrands.intellij.sloppyfocus.util

import com.intellij.openapi.diagnostic.Logger

val pluginLogger: Logger by lazy {
    Logger.getInstance("dev.willebrands.intellij.sloppyfocus")
}
