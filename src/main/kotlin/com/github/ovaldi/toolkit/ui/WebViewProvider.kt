package com.github.ovaldi.toolkit.ui

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.LightVirtualFile

class WebViewProvider: FileEditorProvider, DumbAware {

    override fun createEditor(project: Project, file: VirtualFile): FileEditor = WebView(file as LightVirtualFile)

    override fun getPolicy(): FileEditorPolicy = FileEditorPolicy.HIDE_DEFAULT_EDITOR

    override fun accept(project: Project, file: VirtualFile): Boolean {
        return file.name == WebView.NAME && file is LightVirtualFile
    }

    override fun getEditorTypeId(): String = WebView.NAME

}
