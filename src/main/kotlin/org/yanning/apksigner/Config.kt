package org.yanning.apksigner

import java.io.File

class PATH {
    companion object {
        val CONFIG_DIR: String = File(System.getProperty("user.home"), ".ApkSigner").apply {
            if (!exists()) {
                mkdir()
            }
            if (isFile) {
                delete()
                mkdir()
            }
        }.absolutePath
        val CONFIG_FILE: String = File(CONFIG_DIR, "config.json").apply {
            if (!exists()) {
                createNewFile()
            }
            if (isDirectory) {
                delete()
                createNewFile()
            }
        }.absolutePath
    }
}

class Config {
    var ANDROID_HOME:String?=null
    var SIGNER_TOOL: String? = null
    var keyStores= arrayListOf<KeyStore>()
}

class KeyStore {
    var storeFile: String? = null
    var storePassword: String? = null
    var keyAlias: String? = null
    var keyPassword: String? = null
}