package dev.willebrands.intellij.sloppyfocus.filters

import com.intellij.openapi.editor.impl.EditorComponentImpl
import com.intellij.terminal.TerminalUtils
import com.intellij.util.ui.UIUtil

object ComponentTypeFilters {
    val anyFocusable = ComponentFilter { UIUtil.isFocusable(it) }
    val isTerminal = ComponentFilter { TerminalUtils.isTerminalComponent(it) }
    val isEditor = ComponentFilter { it is EditorComponentImpl }
}