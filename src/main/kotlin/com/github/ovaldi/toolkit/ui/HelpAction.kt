package com.github.ovaldi.toolkit.ui

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project

class HelpAction(private val project: Project): AnAction(AllIcons.Actions.Help) {
    override fun actionPerformed(e: AnActionEvent) {
        WebView.open(project, "https://cloudstudio.net/docs")
    }
}
