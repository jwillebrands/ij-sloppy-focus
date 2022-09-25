package dev.willebrands.intellij.sloppyfocus.mouse

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import dev.willebrands.intellij.sloppyfocus.util.pluginLogger
import java.awt.Toolkit

@Service(Service.Level.PROJECT)
class AwtMouseMonitor(project: Project) : Disposable {
    private val awtMouseEventPublisher: AwtMouseEventPublisher = AwtMouseEventPublisher(project.messageBus)

    fun startListener() {
        setupAwtListenerBridge()
    }

    private fun setupAwtListenerBridge() {
        val toolkit = Toolkit.getDefaultToolkit()
        toolkit.addAWTEventListener(awtMouseEventPublisher, awtMouseEventPublisher.awtEventMask)
        Disposer.register(this) {
            logger.info("Removing AWT event Listener")
            toolkit.removeAWTEventListener(awtMouseEventPublisher)
        }
    }

    override fun dispose() {
        logger.info("Disposing AwtMouseMonitor")
    }

    companion object {
        private val logger = pluginLogger
    }
}
