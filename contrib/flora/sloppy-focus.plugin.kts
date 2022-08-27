import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.diagnostic.debug


class SloppyFocusService : EditorMouseListener {
    companion object {
        private val logger = Logger.getInstance(SloppyFocusService::class.java)
    }

    override fun mouseEntered(event: EditorMouseEvent) {
        logger.debug { "Entered editor ${getEditorName(event.editor)}" }
        changeFocusToEditor(editor = event.editor)
    }

    override fun mouseExited(event: EditorMouseEvent) {
        logger.debug { "Exited editor ${getEditorName(event.editor)}" }
    }

    private fun changeFocusToEditor(editor: Editor) {
        val focusManager = IdeFocusManager.getInstance(editor.project)
        focusManager.requestFocus(editor.contentComponent, true)
    }

    private fun getEditorName(editor: Editor): String {
        return FileDocumentManager.getInstance().getFile(editor.document)
            ?.name ?: "unnamed"
    }
}

EditorFactory.getInstance().eventMulticaster.addEditorMouseListener(SloppyFocusService(), ide.pluginDisposable)