package dev.willebrands.intellij.sloppyfocus.mouse

import com.intellij.util.messages.Topic

interface ComponentMouseListener {
    fun mouseEntered(event: ComponentMouseEvent)
    fun mouseExited(event: ComponentMouseEvent)

    companion object {
        @Topic.ProjectLevel
        val MOUSE_EVENT_TOPIC: Topic<ComponentMouseListener> =
            Topic.create("Component mouse events", ComponentMouseListener::class.java)
    }
}