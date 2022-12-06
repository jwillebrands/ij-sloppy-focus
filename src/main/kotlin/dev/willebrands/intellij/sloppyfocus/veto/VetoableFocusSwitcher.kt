package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.openapi.extensions.ExtensionPointName
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.IdeFocusManager
import dev.willebrands.intellij.sloppyfocus.FocusSwitcher
import java.awt.Component

class VetoableFocusSwitcher(private val project: Project) : FocusSwitcher {
    private val vetoersExtensionPoint: ExtensionPointName<VetoableFocusSwitchListener> =
        ExtensionPointName.create("dev.willebrands.intellij.sloppyfocus.vetoableFocusSwitchListener")

    override fun switchFocus(target: Component) {
        if (vetoersExtensionPoint.extensions.all { it.allowFocusSwitch(target, project) }) {
            IdeFocusManager.getInstance(project).requestFocus(target, true)
        }
    }
}