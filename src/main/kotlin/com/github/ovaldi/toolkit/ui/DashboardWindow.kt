package com.github.ovaldi.toolkit.ui

import com.intellij.icons.AllIcons
import com.intellij.openapi.Disposable
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionToolbar
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.actionSystem.Separator
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.ui.JBColor
import com.intellij.ui.components.JBPanelWithEmptyText
import javax.swing.BorderFactory
import javax.swing.JPanel

class DashboardWindow(project: Project) : Disposable {
    private var project: Project? = null
    private var panel: JPanel? = null

    init {
        this.project = project
        init()
    }

    private fun init() {
        val x = SimpleToolWindowPanel(true, false)

        val settings = DefaultActionGroup()
        settings.templatePresentation.text = "Settings"
        settings.templatePresentation.description = "Settings"
        settings.templatePresentation.icon = AllIcons.General.GearPlain
        settings.isPopup = true
        settings.add(ResetAction(project!!))

        val actions = DefaultActionGroup()
        actions.add(HelpAction(project!!))
        actions.add(Separator())
        actions.add(settings)

        val toolbar = ActionManager.getInstance().createActionToolbar("Toolbar", actions, true)
        toolbar.targetComponent = x
        x.toolbar = toolbar.component

        val b = JBPanelWithEmptyText().withEmptyText("Hello")
        b.border = BorderFactory.createMatteBorder(1, 0, 0, 0, JBColor(0xD5D5D5, 0x323232))
        x.add(b)

        panel = x
    }

    fun getPanel(): JPanel? {
        return panel
    }

    override fun dispose() {
        // TODO
    }
}
