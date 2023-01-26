package com.example.mylibrary.message.factory

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import com.example.mylibrary.R
import com.example.mylibrary.message.style.MessageStyle

data class MessageAttrs (
    val title: String?,
    val subTitle: String?,
    val image: Drawable?,
    val messageStyle: MessageStyle
        )

internal object MessageAttrsParser {
    private const val ANDES_MESSAGE_HIERARCHY_LOUD = "1000"
    private const val ANDES_MESSAGE_HIERARCHY_QUIET = "1001"

    fun parse(context: Context, attr: AttributeSet?): MessageAttrs {
        val messageArray = context.obtainStyledAttributes(attr, R.styleable.message)
        val style = when (messageArray.getString(R.styleable.message_MessageStyle)) {
            ANDES_MESSAGE_HIERARCHY_LOUD -> MessageStyle.LOUD
            ANDES_MESSAGE_HIERARCHY_QUIET -> MessageStyle.QUIET
            else -> MessageStyle.QUIET
        }

        return MessageAttrs(

            title = messageArray.getString(R.styleable.message_MessageTitleText),
            subTitle = messageArray.getString(R.styleable.message_MessageSubTitleText),
            image = messageArray.getDrawable(R.styleable.message_MessageImage),
            messageStyle = style
        )
    }
}