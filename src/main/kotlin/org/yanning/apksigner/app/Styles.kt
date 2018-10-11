package org.yanning.apksigner.app

import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.GraphicsEnvironment

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        private var FONT_FAMILY: String?=null
        fun getFontFamily(): String? {
            if (FONT_FAMILY==null){
                val fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().availableFontFamilyNames
                if (fonts.contains("Ubuntu Mono")) {
                    FONT_FAMILY = "Ubuntu Mono"
                }
            }
            return FONT_FAMILY
        }
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            getFontFamily()?.apply {
                fontFamily =this
            }
        }
    }
}