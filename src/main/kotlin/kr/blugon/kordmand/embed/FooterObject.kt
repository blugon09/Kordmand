package kr.blugon.embed

import dev.kord.rest.builder.message.EmbedBuilder

class FooterObject(val text : String) {
    var icon : String? = null

    constructor(text : String, icon : String) : this(text) {
        this.icon = icon
    }


    fun build() : EmbedBuilder.Footer {
        val footer = EmbedBuilder.Footer()
        footer.text = text
        footer.icon = icon

        return footer
    }
}