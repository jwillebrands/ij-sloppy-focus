package dev.willebrands.intellij.sloppyfocus.mouse

import com.intellij.util.messages.MessageBus
import java.awt.AWTEvent
import java.awt.event.AWTEventListener
import java.awt.event.MouseEvent

class AwtMouseEventPublisher(private val messageBus: MessageBus) : AWTEventListener {
    val awtEventMask = MouseEvent.MOUSE_EVENT_MASK
    private val mouseEventPublisher
        get() = messageBus.syncPublisher(ComponentMouseListener.MOUSE_EVENT_TOPIC)

    override fun eventDispatched(event: AWTEvent?) {
        when (event?.id) {
            MouseEvent.MOUSE_ENTERED -> handleEnteredEvent(event as MouseEvent)
            MouseEvent.MOUSE_EXITED -> handleExitedEvent(event as MouseEvent)
        }
    }

    private fun handleEnteredEvent(mouseEvent: MouseEvent) {
        val component = mouseEvent.component
        mouseEventPublisher.mouseEntered(ComponentMouseEvent(component))
    }

    private fun handleExitedEvent(mouseEvent: MouseEvent) {
        val component = mouseEvent.component
        mouseEventPublisher.mouseExited(ComponentMouseEvent(component))
    }
}