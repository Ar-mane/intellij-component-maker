package ma.armane.componentMaker.config

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.roots.ProjectRootManager
import ma.armane.componentMaker.constant.Constants

class ConfigLoader {

    companion object {

        private var DEFAULT_CONFIG = Config(".templates", "_ComponentName_")
        val mapper = jacksonObjectMapper()

        fun getConfig(event: AnActionEvent): Config? {
            val root = ProjectRootManager.getInstance(event.project!!).contentRoots.first();
            val file = root.findChild(Constants.CONFIG_FILE_PATH) ?: return null;
            var content = FileDocumentManager.getInstance().getDocument(file)?.charsSequence;

            return mapper.readValue(content.toString(), Config::class.java)
        }

        fun saveConfig(event: AnActionEvent) {
            val app = ApplicationManager.getApplication()
            val root = ProjectRootManager.getInstance(event.project!!).contentRoots.first();

            app.invokeLater {
                app.runWriteAction {
                    val configDestination = root.createChildData(null, Constants.CONFIG_FILE_PATH);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(configDestination.getOutputStream(null), this.DEFAULT_CONFIG)
                }
            }
        }
    }
}
