package com.example.components.message.style


interface MessageStyleInterface {

    fun backgroundColor() : Int
}

internal object MessageLoudStyle  : MessageStyleInterface {
    override fun backgroundColor(): Int = androidx.appcompat.R.color.primary_dark_material_light


}

internal object MessageQuietStyle  : MessageStyleInterface {
    override fun backgroundColor(): Int = androidx.appcompat.R.color.primary_material_light

}