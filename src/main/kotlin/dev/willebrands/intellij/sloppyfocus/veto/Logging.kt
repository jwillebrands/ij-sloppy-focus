package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.openapi.diagnostic.debug
import dev.willebrands.intellij.sloppyfocus.util.componentLogger

fun logVetoDecision(allowSwitch: Boolean, messageProvider: () -> String) {
    componentLogger("veto").debug {
        "Focus switch ${if (allowSwitch) "allowed" else "vetoed"}: ${messageProvider()}"
    }
}
