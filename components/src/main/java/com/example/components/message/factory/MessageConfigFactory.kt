package com.example.mylibrary.message.factory

import com.example.mylibrary.message.style.MessageStyleInterface

internal data class MessageConfig (
    val backgroundColor: Int
        )

@Suppress("TooManyFunctions")
internal object MessageConfigFactory {
    fun create(messageAttrs: MessageAttrs): MessageConfig {
        return with(messageAttrs) {
            MessageConfig(
                backgroundColor = resolveBackgroundColor(messageStyle.style)
            )
        }
    }

    private fun resolveBackgroundColor(style: MessageStyleInterface) = style.backgroundColor()
}