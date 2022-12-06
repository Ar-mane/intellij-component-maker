package ma.armane.componentMaker;

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import ma.armane.componentMaker.config.ConfigLoader
import ma.armane.componentMaker.ui.ConfigInitializer


class Command : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
//        val selectedElement = event.getData(CommonDataKeys.VIRTUAL_FILE)
        var config = ConfigLoader.getConfig(event);
        if (config == null) {
            ConfigInitializer.init(event);
            return;
        }
    }


}
