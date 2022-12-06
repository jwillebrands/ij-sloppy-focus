package dev.willebrands.intellij.sloppyfocus.veto

import com.intellij.openapi.project.Project
import java.awt.Component

interface VetoableFocusSwitchListener {
    fun allowFocusSwitch(target: Component, project: Project): Boolean
}