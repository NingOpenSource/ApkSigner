package org.yanning.apksigner.view

import javafx.scene.paint.Paint
import tornadofx.*

class AboutView : View("About") {
    override val root = vbox {
        webview {
            engine.load("https://tornadofx.io/")
            style{
                backgroundColor= multi(Paint.valueOf("#ffff00"))
                minWidth=200.px
                minHeight=200.px
            }
        }
    }
}
