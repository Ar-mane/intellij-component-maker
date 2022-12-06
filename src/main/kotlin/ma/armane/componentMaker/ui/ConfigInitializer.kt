package ma.armane.componentMaker.ui

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import ma.armane.componentMaker.config.ConfigLoader
import ma.armane.componentMaker.constant.Constants

class ConfigInitializer {
    companion object {
        fun init(event: AnActionEvent) {

            val choice = Messages.showOkCancelDialog(Constants.NO_CONFIG_FOUND_MESSAGE, "Information", "Yes", "No", icons.ExternalSystemIcons.Task);
            if (choice != Messages.OK) return;
            ConfigLoader.saveConfig(event)
        }
    }
}
