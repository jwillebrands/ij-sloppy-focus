package dev.willebrands.intellij.sloppyfocus

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import dev.willebrands.intellij.sloppyfocus.mouse.AwtMouseMonitor
import dev.willebrands.intellij.sloppyfocus.util.pluginLogger

class BackgroundServiceStarter : StartupActivity.DumbAware {
    override fun runActivity(project: Project) {
        pluginLogger.debug("Starting AWTMouseMonitor for project $project")
        project.service<AwtMouseMonitor>().startListener()
    }
}