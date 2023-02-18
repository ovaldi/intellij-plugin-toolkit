package com.github.ovaldi.toolkit.ui

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorLocation
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorState
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.LightVirtualFile
import com.intellij.ui.components.JBPanelWithEmptyText
import com.intellij.ui.jcef.JBCefApp
import com.intellij.ui.jcef.JBCefBrowser
import java.awt.GridLayout
import java.beans.PropertyChangeListener
import javax.swing.JComponent
import javax.swing.JPanel

class WebView(private var file: LightVirtualFile): UserDataHolderBase(), FileEditor {
    private var component: JPanel = JBPanelWithEmptyText().withEmptyText("JCEF is not supported")

    init {
        if (JBCefApp.isSupported() ) {
            val browser = JBCefBrowser(file.content.toString())
            component.add(browser.component)
            component.layout = GridLayout(1, 1)
        }
    }

    companion object {
        const val NAME = "webview"

        fun open(project: Project, url: String) {
            val file = LightVirtualFile(NAME, url)
            FileEditorManager.getInstance(project).openFile(file, true);
        }
    }

    override fun getComponent(): JComponent = component

    override fun getPreferredFocusedComponent(): JComponent? = null

    override fun getName(): String = "WebView"

    override fun dispose() { }

    override fun setState(state: FileEditorState) { }

    override fun isModified(): Boolean = false

    override fun isValid(): Boolean = true

    override fun addPropertyChangeListener(listener: PropertyChangeListener) { }

    override fun removePropertyChangeListener(listener: PropertyChangeListener) { }

    override fun getCurrentLocation(): FileEditorLocation? = null

    override fun getFile(): VirtualFile = file
}
