package com.github.ovaldi.toolkit.ui

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory


class BrowserWindowFactory : ToolWindowFactory, DumbAware {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val bw = BrowserWindow(project)
        val cm = toolWindow.contentManager
        val content = ContentFactory.SERVICE.getInstance().createContent(bw.getPanel(), "", false)
        cm.addContent(content)
        cm.setSelectedContent(content)

//        if (toolWindow is ToolWindowEx) {
//            toolWindow.stretchWidth(1000)
//        }

        WebView.open(project, "https://www.baidu.com")
    }
}
