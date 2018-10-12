package org.yanning.apksigner.view

import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.stage.FileChooser
import org.yanning.apksigner.app.Styles
import tornadofx.*
import java.io.File

class MainView : View("ApkSigner") {
    val apkPath = SimpleStringProperty()
    val outputPath = SimpleStringProperty()
    val keyStore = SimpleStringProperty()
    val logs = SimpleStringProperty().apply {
        value = "ApkSigner v0.0.1 logs"
    }

    override val root = vbox {
        menubar {
            menu("File") {
                item("Setting") {
                    action {
                        SettingView().openModal()
                    }
                }
            }
            menu("Help") {
                item("About") {
                    action {
                        AboutView().openModal()
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
            fieldset("ApkSigner v0.0.1") {
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
                field("keyStore file") {
                    choicebox(keyStore, arrayListOf("1", "2", "3", "4")) {
                        value = items[0]
                        style {
                            minWidth = 150.px
                        }
                    }
                    button("import") {
                        action {
                            ImportKeyStoreView().openModal()
                        }
                        style {
                            minWidth = 80.px
                        }
                    }
                    button("manage") {
                        action {
                            SettingView().openModal()
                        }
                        style {
                            minWidth = 80.px
                        }
                    }
                }
                field {
                    textarea(logs) {
                        isEditable = false
                    }
                }
                field {
                    hbox {
                        button("sign") {
                            onAction = EventHandler {
                                tooltip("-----------------------------sign------------------")
                            }
                            style {
                                minWidth = 120.px
                            }
                        }
                        style {
                            alignment = Pos.CENTER_RIGHT
                        }
                    }
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