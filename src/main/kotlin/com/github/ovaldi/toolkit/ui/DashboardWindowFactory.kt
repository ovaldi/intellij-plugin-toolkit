package com.github.ovaldi.toolkit.ui

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class DashboardWindowFactory : ToolWindowFactory, DumbAware {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val dw = DashboardWindow(project)
        val cm = toolWindow.contentManager
        val content = ContentFactory.SERVICE.getInstance().createContent(dw.getPanel(), "", false)
        cm.addContent(content)
        cm.setSelectedContent(content)

//        if (toolWindow is ToolWindowEx) {
//            toolWindow.stretchWidth(1000)
//        }
    }
}
