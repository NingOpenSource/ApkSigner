package org.yanning.apksigner.view

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.stage.FileChooser
import org.yanning.apksigner.app.Styles
import tornadofx.*

class ImportKeyStoreView : View("Import keyStore") {
    val storeFile = SimpleStringProperty()
    val storePassword = SimpleStringProperty()
    val keyAlias = SimpleStringProperty()
    val keyPassword = SimpleStringProperty()
    override val root = form {
        fieldset {
            field("storeFile") {
                textfield(storeFile)
                button("choose") {
                    setOnAction {
                        val apkFile = chooseFile("keyStore picker",
                                arrayOf(FileChooser.ExtensionFilter("keyStore file", "*")),
                                FileChooserMode.Single, currentWindow)
                        storeFile.set(apkFile.firstOrNull()?.absolutePath)
                    }
                    style {
                        minWidth = 80.px
                    }
                }
            }
            field("storePassword") {
                textfield(storePassword)
            }
            field("keyAlias") {
                textfield(keyAlias)
            }
            field("keyPassword") {
                textfield(keyPassword)
            }
            field {
                hbox {
                    button("ok") {
                        action {
                            tooltip("import success!") {

                            }
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
