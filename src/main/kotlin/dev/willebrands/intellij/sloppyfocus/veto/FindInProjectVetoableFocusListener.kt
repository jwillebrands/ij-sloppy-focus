package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.find.impl.FindUI
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.IdeFocusManager
import com.intellij.util.ui.UIUtil
import java.awt.Component

class FindInProjectVetoableFocusListener : VetoableFocusSwitchListener {
    override fun allowFocusSwitch(target: Component, project: Project): Boolean {
        /**
         * Unfortunately, I could not find a Find/Replace related Manager we can ask about the state of the modal.
         * Therefor we resort to checking whether the current focus owner is (a child of) a FindUI component.
         * If it is, the focus switch is vetoed.
         */
        val focusOwner = IdeFocusManager.getInstance(project).focusOwner
        val parentFindUI = UIUtil.getParentOfType(FindUI::class.java, focusOwner)
        val isChildOfFindUI = parentFindUI != null
        val targetIsChildOfFindPopupPanel = parentFindUI
            ?.let { it as? Component }
            ?.let { UIUtil.isDescendingFrom(target, it) } ?: false
        return decideAndLog(!isChildOfFindUI || targetIsChildOfFindPopupPanel) {
            "Focus owner is child of findUI: $isChildOfFindUI; " +
                    "target is child of findUI: $targetIsChildOfFindPopupPanel"
        }
    }
}
