package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.ide.actions.searcheverywhere.SearchEverywhereManager
import com.intellij.openapi.project.Project
import java.awt.Component

class SearchEverywhereVetoableFocusListener : VetoableFocusSwitchListener {
    override fun allowFocusSwitch(target: Component, project: Project): Boolean {
        return !SearchEverywhereManager.getInstance(project).isShown
    }
}