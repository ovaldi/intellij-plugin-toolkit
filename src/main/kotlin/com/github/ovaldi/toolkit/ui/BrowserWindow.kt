package com.github.ovaldi.toolkit.ui

import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.ui.jcef.JBCefApp
import com.intellij.ui.jcef.JBCefBrowser
import javax.swing.BorderFactory
import javax.swing.JPanel


class BrowserWindow(project: Project) : Disposable {
    private var project: Project? = null
    private var panel: JPanel? = null

    init {
        this.project = project
        init()
    }

    private fun init() {
        if (!JBCefApp.isSupported()) {
            // Fallback to an alternative browser-less solution
            return
        }
        val browser = JBCefBrowser("https://cloudstudio.net")
        val x = SimpleToolWindowPanel(true, false)
        x.border = BorderFactory.createEmptyBorder(0, 3, 0, 0)
        x.add(browser.component)
        this.panel = x
    }

    fun getPanel(): JPanel? {
        return panel
    }

    override fun dispose() {
        // TODO
    }
}
