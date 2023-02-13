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
        val x = SimpleToolWindowPanel(true, false)
        x.border = BorderFactory.createEmptyBorder(0, 3, 0, 0)
        this.project = project
        this.panel = x
        init()
    }

    private fun init() {
        if (!JBCefApp.isSupported()) {
            // Fallback to an alternative browser-less solution
            return
        }
        val browser = JBCefBrowser("https://www.baidu.com")
        panel!!.add(browser.component)
    }

    fun getPanel(): JPanel? {
        return panel
    }

    override fun dispose() {
        // TODO
    }
}