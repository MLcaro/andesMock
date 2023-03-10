package com.example.mylibrary.message

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.components.R
import com.example.components.message.factory.MessageAttrs
import com.example.components.message.factory.MessageAttrsParser
import com.example.components.message.factory.MessageConfig
import com.example.components.message.factory.MessageConfigFactory
import com.example.components.message.style.MessageStyle
import com.example.components.message.style.MessageStyleInterface


@Suppress("TooManyFunctions")
class Message : CardView {

    private var messageAttrs: MessageAttrs

    var title: String? = null
    var subTitle: String? = null
    var image: Drawable? = null
    var style: MessageStyle = MessageStyle.QUIET

    private lateinit var messageContainer: ConstraintLayout
    private lateinit var titleComponent: TextView
    private lateinit var subTitleComponent: TextView
    private lateinit var imageComponent: ImageView

    @Suppress("unused")
    private constructor(context: Context) : this(context,null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        messageAttrs = MessageAttrsParser.parse(context, attrs)
        initAttrs()
    }


    @Suppress("unused", "LongParameterList")
    @JvmOverloads
    constructor(
        context: Context,
        title: String? = "",
        subTitle: String?,
        image: Drawable? = null,
        messageStyle: MessageStyle
    ) : super(context) {
        messageAttrs = MessageAttrs(title, subTitle, image, messageStyle)
        initAttrs()
    }

    public fun changeBack(style : MessageStyleInterface) = apply { this.setCardBackgroundColor(style.backgroundColor())  }

    private fun initAttrs() {
        val config = MessageConfigFactory.create(messageAttrs)
        setupComponents(config)
    }

    private fun setupComponents(config: MessageConfig) {
        initComponents()
        radius = 4f
        cardElevation = 0f
        preventCornerOverlap = true
        setCardBackgroundColor(config.backgroundColor)
        imageComponent.setImageDrawable(image)

    }

    private fun initComponents() {
        val container = LayoutInflater.from(context).inflate(
            R.layout.message_layout,
            this, true
        )
        messageContainer = container.findViewById(R.id.message_card)
        titleComponent = container.findViewById(R.id.message_title)
        subTitleComponent = container.findViewById(R.id.message_subtitle)
        imageComponent = container.findViewById(R.id.message_imageView)

    }
}