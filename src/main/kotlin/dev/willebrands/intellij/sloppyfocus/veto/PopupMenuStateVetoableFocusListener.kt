package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.openapi.actionSystem.ex.ActionManagerEx
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.popup.JBPopupFactory
import java.awt.Component

class PopupMenuStateVetoableFocusListener : VetoableFocusSwitchListener {
    override fun allowFocusSwitch(target: Component, project: Project): Boolean {
        val actionPopupStackEmpty = ActionManagerEx.getInstanceEx().isActionPopupStackEmpty
        val popupActive = JBPopupFactory.getInstance().isPopupActive
        val allowFocusSwitch = actionPopupStackEmpty && !popupActive
        logVetoDecision(allowFocusSwitch) {
            "Action popup stack empty = $actionPopupStackEmpty; popup active = $popupActive"
        }
        return allowFocusSwitch
    }
}
