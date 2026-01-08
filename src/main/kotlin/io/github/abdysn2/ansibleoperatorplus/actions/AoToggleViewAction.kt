package io.github.abdysn2.ansibleoperatorplus.actions

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareToggleAction

class AoToggleViewAction(
    text: String,
    private val viewId: String,
    private val getCurrentView: () -> String,
    private val setCurrentView: (String) -> Unit,
) : DumbAwareToggleAction(text) {

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.EDT

    override fun isSelected(e: AnActionEvent): Boolean {
        return getCurrentView() == viewId
    }

    override fun setSelected(e: AnActionEvent, state: Boolean) {
        if (state) setCurrentView(viewId)
    }
}
