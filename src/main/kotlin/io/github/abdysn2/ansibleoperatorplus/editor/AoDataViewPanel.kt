package io.github.abdysn2.ansibleoperatorplus.editor

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.table.JBTable
import java.awt.BorderLayout
import javax.swing.JPanel
import javax.swing.table.DefaultTableModel

class AoDataViewPanel(
    project: Project,
    file: VirtualFile
) : JPanel(BorderLayout()) {

    init {
        // Placeholder table — replace later with real inventory/table model.
        val model = DefaultTableModel(
            arrayOf(
                arrayOf("ansibleOperator+", "Data view placeholder"),
                arrayOf("File", file.name),
            ),
            arrayOf("Key", "Value"),
        )

        val table = JBTable(model)
        add(JBScrollPane(table), BorderLayout.CENTER)
    }
}
