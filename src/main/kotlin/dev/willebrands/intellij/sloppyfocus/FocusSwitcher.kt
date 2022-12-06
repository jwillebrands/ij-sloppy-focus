package dev.willebrands.intellij.sloppyfocus

import java.awt.Component

interface FocusSwitcher {
    fun switchFocus(target: Component)
}
