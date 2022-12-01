package ma.armane.componentMaker;

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages


class Command : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showInfoMessage(e.getProject(), e.getProject()?.getProjectFilePath(), "this is my first title");
    }
}
