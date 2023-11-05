package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.openapi.diagnostic.debug
import dev.willebrands.intellij.sloppyfocus.util.componentLogger

inline fun decideAndLog(allowSwitch: Boolean, messageProvider: () -> String): Boolean = allowSwitch.also {
    componentLogger("veto").debug {
        "Focus switch ${if (allowSwitch) "allowed" else "vetoed"}: ${messageProvider()}"
    }
}