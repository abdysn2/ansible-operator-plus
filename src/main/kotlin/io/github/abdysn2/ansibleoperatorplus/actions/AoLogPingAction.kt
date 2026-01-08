package io.github.abdysn2.ansibleoperatorplus.actions

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class AoLogPingAction : AnAction("Ping", "Log ping from Ao editor", ICON) {
    private val log = Logger.getInstance(AoLogPingAction::class.java)

    override fun actionPerformed(e: AnActionEvent) {
        log.info("ansibleOperator+: ping from editor header button")
    }

    private companion object {
        val ICON: Icon = IconLoader.getIcon("/icons/ansibleoperatorpluslogo.svg", AoLogPingAction::class.java)
    }
}
