package com.github.ovaldi.toolkit.ui

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project

class ResetAction(var project: Project): AnAction("Reset", "", AllIcons.General.Reset) {

    override fun actionPerformed(e: AnActionEvent) {
        WebView.open(project, "https://ovaldi.github.io/")
    }

}
