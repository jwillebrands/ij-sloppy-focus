package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.openapi.actionSystem.ex.ActionManagerEx
import com.intellij.openapi.project.Project
import java.awt.Component

class PopupMenuStateVetoableFocusListener : VetoableFocusSwitchListener {
    override fun allowFocusSwitch(target: Component, project: Project): Boolean {
        return ActionManagerEx.getInstanceEx().isActionPopupStackEmpty
    }
}