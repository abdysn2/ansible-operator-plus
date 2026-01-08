package io.github.abdysn2.ansibleoperatorplus.editor

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorState
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.fileEditor.impl.text.TextEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.openapi.vfs.VirtualFile
import io.github.abdysn2.ansibleoperatorplus.actions.AoLogPingAction
import io.github.abdysn2.ansibleoperatorplus.actions.AoToggleViewAction
import java.awt.BorderLayout
import java.awt.CardLayout
import java.awt.FlowLayout
import java.beans.PropertyChangeListener
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

class AoSplitEditor(private val project: Project, private val file: VirtualFile) : UserDataHolderBase(), FileEditor {

    private var currentViewId = "DATA"

    private val textEditor: TextEditor =
        TextEditorProvider.getInstance().createEditor(project, file) as TextEditor

    private val cards = JPanel(CardLayout())
    private val root = JPanel(BorderLayout())

    init {
        // CENTER: cards
        val dataView = AoDataViewPanel(project, file) // your table/placeholder
        cards.add(textEditor.component, "TEXT")
        cards.add(dataView, "DATA")
        root.add(cards, BorderLayout.CENTER)

        // NORTH: header (right-aligned label + action)
        root.add(createHeader(), BorderLayout.NORTH)

        // SOUTH: bottom-left Text/Data toggle
        root.add(createBottomToggle(), BorderLayout.SOUTH)

        show("DATA") // or "TEXT" default
    }

    private fun show(which: String) {
        currentViewId = which
        (cards.layout as CardLayout).show(cards, which)
    }

    private fun createHeader(): JComponent {
        val panel = JPanel(BorderLayout())

        // Right side: "(logo)ansibleOperator+" + one button
        val right = JPanel(FlowLayout(FlowLayout.RIGHT, 8, 0))
        right.add(JLabel("(logo) ansibleOperator+")) // replace with icon + text later

        val actionGroup = DefaultActionGroup(AoLogPingAction())
        val toolbar = ActionManager.getInstance().createActionToolbar("AO_HEADER", actionGroup, true)
        toolbar.setTargetComponent(panel)

        right.add(toolbar.component)
        panel.add(right, BorderLayout.EAST)
        return panel
    }

    private fun createBottomToggle(): JComponent {
        // Use ToggleAction(s) so it feels like a segmented switch
        val group = DefaultActionGroup(
            AoToggleViewAction("Text", "TEXT", { currentViewId }, { show(it) }),
            AoToggleViewAction("Data", "DATA", { currentViewId }, { show(it) }),
        )

        val toolbar = ActionManager.getInstance().createActionToolbar("AO_BOTTOM_TOGGLE", group, true)
        val panel = JPanel(BorderLayout())
        toolbar.targetComponent = panel

        // Make it align bottom-left
        panel.add(toolbar.component, BorderLayout.WEST)
        return panel
    }

    override fun getComponent(): JComponent = root
    override fun getPreferredFocusedComponent(): JComponent? = textEditor.preferredFocusedComponent
    override fun getName(): String = "AnsibleOperator+"
    override fun getFile(): VirtualFile = file
    override fun setState(state: FileEditorState) {}
    override fun isModified(): Boolean = false
    override fun isValid(): Boolean = file.isValid
    override fun addPropertyChangeListener(listener: PropertyChangeListener) {}
    override fun removePropertyChangeListener(listener: PropertyChangeListener) {}
    override fun dispose() { textEditor.dispose() }
}
