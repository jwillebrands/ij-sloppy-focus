package dev.willebrands.intellij.sloppyfocus.settings

import com.intellij.openapi.components.*

class SloppyFocusSettingsState : BaseState() {
    var focusDelayMs by property(200)
    var focusEditorAndTerminalOnly by property(true)
}