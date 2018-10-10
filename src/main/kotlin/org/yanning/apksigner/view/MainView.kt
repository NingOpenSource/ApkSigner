package org.yanning.apksigner.view

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.input.KeyCombination
import javafx.stage.FileChooser
import org.yanning.apksigner.app.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    val apkPath = SimpleStringProperty()
    override val root = vbox {
        menubar {
            menu("File") {
                item("Setting") {
                    action {
                        println("-----------------------------ok------------------")
                    }
                }
            }
            menu("Help") {
                item("About") {
                    println("-----------------------------about------------------")
                }
            }
            style {
                Styles.getFontFamily()?.apply {
                    fontFamily = this
                }
            }
        }
        form {
            fieldset("Config") {
                field("apk path") {
                    textfield(apkPath)
                    button("choose").onAction = EventHandler {
                        val apkFile = chooseFile("apk picker",
                                arrayOf(FileChooser.ExtensionFilter("apk", "*.apk")),
                                FileChooserMode.Single, currentWindow)
                        apkPath.set(apkFile.firstOrNull()?.absolutePath)
                    }
                }
                field("output path") {
                    textfield { }
                }
            }
            style {
                Styles.getFontFamily()?.apply {
                    fontFamily = this
                }
            }
        }
    }
}