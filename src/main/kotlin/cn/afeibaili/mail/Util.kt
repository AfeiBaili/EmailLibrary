package cn.afeibaili.mail

import java.util.*

fun buildProperties(vararg pairs: Pair<String, String>): Properties {
    val properties = Properties()
    properties.putAll(pairs)
    return properties
}