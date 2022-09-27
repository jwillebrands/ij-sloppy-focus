package dev.willebrands.intellij.sloppyfocus.settings

import com.intellij.openapi.components.SimplePersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.service

@State(
    name = "dev.willebrands.intellij.sloppyfocus.settings.SloppyFocusSettings",
    storages = [Storage("SloppyFocusPlugin.xml")]
)
class SloppyFocusSettings : SimplePersistentStateComponent<SloppyFocusSettingsState>(SloppyFocusSettingsState()) {
    var focusDelayMs
        get() = state.focusDelayMs
        set(value) {
            state.focusDelayMs = value
        }

    var focusEditorAndTerminalOnly
        get() = state.focusEditorAndTerminalOnly
        set(value) {
            state.focusEditorAndTerminalOnly = value
        }

    companion object {
        @JvmStatic
        fun getInstance(): SloppyFocusSettings = service()
    }
}