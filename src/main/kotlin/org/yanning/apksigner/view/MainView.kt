package org.yanning.apksigner.view

import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.stage.FileChooser
import org.yanning.apksigner.app.Styles
import tornadofx.*
import java.io.File

class MainView : View("Hello TornadoFX") {
    val apkPath = SimpleStringProperty()
    val outputPath = SimpleStringProperty()
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
                    action {
                        println("-----------------------------about------------------")
                    }
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
                    onDragDropped = EventHandler {
                        it.dragboard.files?.first()?.let {
                            if (it.isFile && it.name.endsWith(".apk"))
                                apkPath.set(it.absolutePath)
                        }
                    }
                    button("choose") {
                        onAction = EventHandler {
                            val apkFile = chooseFile("apk picker",
                                    arrayOf(FileChooser.ExtensionFilter("apk", "*.apk")),
                                    FileChooserMode.Single, currentWindow)
                            apkPath.set(apkFile.firstOrNull()?.absolutePath)
                        }
                        style {
                            minWidth = 80.px
                        }
                    }
                }
                field("output path") {
                    textfield(outputPath)
                    onDragDropped = EventHandler {
                        it.dragboard.files?.first()?.let {
                            if (it.isDirectory)
                                outputPath.set(it.absolutePath)
                        }
                    }
                    button("choose") {
                        onAction = EventHandler {
                            val dir = chooseDirectory("output path", File("./"),
                                    currentWindow)
                            outputPath.set(dir?.absolutePath)
                        }
                        style {
                            minWidth = 80.px
                        }
                    }
                }
            }
            button("sign") {
                onAction = EventHandler {
                    println("-----------------------------sign------------------")
                }
                style {
                    minWidth = 120.px
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