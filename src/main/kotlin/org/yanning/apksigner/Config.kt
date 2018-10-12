package org.yanning.apksigner

import java.io.File

class PATH {
    companion object {
        private fun createDir(dir: File) {
            dir.apply {
                if (!exists()) {
                    mkdir()
                }
                if (isFile) {
                    delete()
                    mkdir()
                }
            }
        }

        private fun createConfigFile(file: File) {
            file.apply {
                if (!exists()) {
                    createNewFile()
                }
                if (isDirectory) {
                    delete()
                    createNewFile()
                }
            }
        }

        /**
         * 配置文件目录
         */
        val CONFIG_DIR: String = File(System.getProperty("user.home"), ".ApkSigner").apply {
            createDir(this)
        }.absolutePath
        /**
         * 主要的配置文件
         */
        val CONFIG_FILE: String = File(CONFIG_DIR, "config.json").apply {
            createConfigFile(this)
        }.absolutePath
        /**
         * 签名证书存储目录
         */
        val KEY_STORE_DIR: String = File(CONFIG_DIR, "keyStore").apply {
            createDir(this)
        }.absolutePath
    }
}

data class Config(
        var SIGNER_TOOL: String? = null,
        var defaultKeyStore: KeyStore?=null)

data class KeyStore(
        var storeFile: String? = null,
        var storePassword: String? = null,
        var keyAlias: String? = null,
        var keyPassword: String? = null)