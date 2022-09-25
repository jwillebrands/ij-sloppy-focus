package dev.willebrands.intellij.sloppyfocus.filters

import com.intellij.openapi.editor.impl.EditorComponentImpl
import com.intellij.terminal.TerminalUtils

object ComponentTypeFilters {
    val isTerminal = ComponentFilter { TerminalUtils.isTerminalComponent(it) }
    val isEditor = ComponentFilter { it is EditorComponentImpl }
}