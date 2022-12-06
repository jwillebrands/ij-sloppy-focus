package dev.willebrands.intellij.sloppyfocus.settings

import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.bindIntText
import com.intellij.ui.dsl.builder.buttonGroup
import com.intellij.ui.dsl.builder.panel

@Suppress("UnstableApiUsage")
class SloppyFocusSettingsConfigurable : BoundConfigurable(
    "Sloppy Focus Settings"
) {
    private val settings
        get() = SloppyFocusSettings.getInstance()

    override fun createPanel(): DialogPanel {
        return panel {
            row("Focus change delay (ms)") {
                intTextField(0..Int.MAX_VALUE, 25).bindIntText(settings::focusDelayMs)
            }
            buttonGroup(
                settings::focusEditorAndTerminalOnly,
                "Focus Target Selection"
            ) {
                row {
                    radioButton("Switch focus to any focusable component", false)
                }
                row {
                    radioButton(
                        "Limit focus switching to editors and terminals", true
                    )
                }
            }
        }
    }
}