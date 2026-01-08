package io.github.abdysn2.ansibleoperatorplus.editor

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile


class AoFileEditorProvider : FileEditorProvider {
    override fun accept(project: Project, file: VirtualFile): Boolean {
        // keep this narrow (don’t steal all YAML):
        // e.g. only accept files matching your plugin’s conventions
        return file.name == "watches.yaml"
    }

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return AoSplitEditor(project, file)
    }

    override fun getEditorTypeId(): String = "ansibleOperatorPlusEditor"
    override fun getPolicy(): FileEditorPolicy = FileEditorPolicy.PLACE_AFTER_DEFAULT_EDITOR
}
