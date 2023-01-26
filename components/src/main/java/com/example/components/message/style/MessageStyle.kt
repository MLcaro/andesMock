package com.example.components.message.style

import java.util.*

enum class MessageStyle {
    QUIET,
    LOUD;

    companion object {
        fun fromString(value: String): MessageStyle = valueOf(value.toUpperCase(Locale.ROOT))
    }

    internal val style get() = getMessageStyle()

    private fun getMessageStyle(): MessageStyleInterface {
        return when (this) {
            QUIET -> MessageQuietStyle
            LOUD -> MessageLoudStyle
        }
    }
}