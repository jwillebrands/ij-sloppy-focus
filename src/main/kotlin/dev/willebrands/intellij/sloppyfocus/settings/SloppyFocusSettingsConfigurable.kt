package dev.willebrands.intellij.sloppyfocus.settings

import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.panel

class SloppyFocusSettingsConfigurable : BoundConfigurable(
    "Sloppy Focus Settings"
) {
    private val settings
        get() = SloppyFocusSettings.getInstance()

    override fun createPanel(): DialogPanel {
        return panel {
            row {
                label("Focus change delay (ms)")
                intTextField(settings::focusDelayMs)
            }
        }
    }
}