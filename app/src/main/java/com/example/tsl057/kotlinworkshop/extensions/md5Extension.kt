package com.example.tsl057.kotlinworkshop.extensions

import java.nio.charset.Charset
import java.security.MessageDigest

fun String.md5(): String {
    val digester = MessageDigest.getInstance("MD5")
    digester.update(this.toByteArray(Charset.defaultCharset()))
    return digester.digest().toHex()
}