package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.find.impl.FindPopupPanel
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.IdeFocusManager
import com.intellij.util.ui.UIUtil
import java.awt.Component

class FindInProjectVetoableFocusListener : VetoableFocusSwitchListener {
    override fun allowFocusSwitch(target: Component, project: Project): Boolean {
        /**
         * Unfortunately, I could not a Find/Replace related Manager we can ask about the state of the modal.
         * Therefor we resort to checking whether the current focus owner is (a child of) the FindPopupPanel.
         * If it is, the focus switch is vetoed.
         */
        val focusOwner = IdeFocusManager.getInstance(project).focusOwner
        val parentFindPopupPanel = UIUtil.getParentOfType(FindPopupPanel::class.java, focusOwner)
        val isChildOfFindPopupPanel = parentFindPopupPanel != null
        val targetIsChildOfFindPopupPanel = parentFindPopupPanel?.let { UIUtil.isDescendingFrom(target, it) } ?: false
        return decideAndLog(!isChildOfFindPopupPanel || targetIsChildOfFindPopupPanel) { "Current focused component is (child of) FindPopupPanel" }
    }
}
