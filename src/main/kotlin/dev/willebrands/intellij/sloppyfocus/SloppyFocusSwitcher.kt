package dev.willebrands.intellij.sloppyfocus

import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.wm.IdeFocusManager
import com.intellij.util.Alarm
import com.intellij.util.ui.UIUtil
import dev.willebrands.intellij.sloppyfocus.filters.ComponentFilter
import dev.willebrands.intellij.sloppyfocus.filters.ComponentTypeFilters
import dev.willebrands.intellij.sloppyfocus.filters.andAnyOf
import dev.willebrands.intellij.sloppyfocus.mouse.ComponentMouseEvent
import dev.willebrands.intellij.sloppyfocus.mouse.ComponentMouseListener
import dev.willebrands.intellij.sloppyfocus.settings.SloppyFocusSettings
import dev.willebrands.intellij.sloppyfocus.util.pluginLogger
import java.awt.Component

class SloppyFocusSwitcher : ComponentMouseListener {
    private val focusSwitcherAlarm = Alarm()
    private val filter: ComponentFilter = ComponentFilter { UIUtil.isFocusable(it) }.andAnyOf(
        ComponentTypeFilters.isEditor
    )

    private val focusDelay
        get() = SloppyFocusSettings.getInstance().focusDelayMs

    override fun mouseEntered(event: ComponentMouseEvent) {
        pluginLogger.debug("mouse entered ${event.component.javaClass.name}")
        if (filter.test(event.component)) {
            focusSwitcherAlarm.cancelAllRequests()
            focusSwitcherAlarm.addRequest({ switchFocus(event.component) }, focusDelay, ModalityState.NON_MODAL)
        }
    }

    override fun mouseExited(event: ComponentMouseEvent) {
        pluginLogger.debug("mouse exited ${event.component.javaClass.name}")
        focusSwitcherAlarm.cancelAllRequests()
    }

    private fun switchFocus(component: Component) {
        IdeFocusManager.getGlobalInstance().requestFocus(component, true)
    }
}