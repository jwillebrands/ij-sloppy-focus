package dev.willebrands.intellij.sloppyfocus

import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.trace
import com.intellij.openapi.project.Project
import com.intellij.util.Alarm
import dev.willebrands.intellij.sloppyfocus.filters.ComponentTypeFilters
import dev.willebrands.intellij.sloppyfocus.filters.andAnyOf
import dev.willebrands.intellij.sloppyfocus.mouse.ComponentMouseEvent
import dev.willebrands.intellij.sloppyfocus.mouse.ComponentMouseListener
import dev.willebrands.intellij.sloppyfocus.settings.SloppyFocusSettings
import dev.willebrands.intellij.sloppyfocus.util.pluginLogger
import java.awt.Component

class SloppyFocusSwitcher(private val project: Project) : ComponentMouseListener {
    private val focusSwitcherAlarm = Alarm()

    private val focusDelay
        get() = SloppyFocusSettings.getInstance().focusDelayMs

    private val componentFilter
        get() = when (SloppyFocusSettings.getInstance().focusEditorAndTerminalOnly) {
            false -> ComponentTypeFilters.anyFocusable
            else -> ComponentTypeFilters.anyFocusable.andAnyOf(
                ComponentTypeFilters.isEditor, ComponentTypeFilters.isTerminal
            )
        }

    override fun mouseEntered(event: ComponentMouseEvent) {
        pluginLogger.trace { "mouse entered ${event.component.javaClass.name}" }
        if (componentFilter.test(event.component)) {
            focusSwitcherAlarm.cancelAllRequests()
            focusSwitcherAlarm.addRequest({ switchFocus(event.component) }, focusDelay, ModalityState.NON_MODAL)
        }
    }

    override fun mouseExited(event: ComponentMouseEvent) {
        pluginLogger.trace { "mouse exited ${event.component.javaClass.name}" }
        focusSwitcherAlarm.cancelAllRequests()
    }

    private fun switchFocus(component: Component) {
        project.service<FocusSwitcher>().switchFocus(component)
    }
}