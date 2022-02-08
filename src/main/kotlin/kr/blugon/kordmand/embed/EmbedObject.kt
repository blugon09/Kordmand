package kr.blugon.kordmand.embed

import dev.kord.rest.builder.message.EmbedBuilder
import dev.kord.common.Color
import kotlin.collections.ArrayList

class EmbedObject(var title: String) {
    var color : Color = Color(0x202225)
    var description : String? = null
    var inLine = true
    val field = ArrayList<FieldObject>()
    var thumbnail : String? = null
    var footer : FooterObject? = null
    var author : AuthorObject? = null
    var image : String? = null

    constructor(title : String, color : Color) : this(title) {
        this.color = color
    }

    constructor(title : String, color : Color, description : String) : this(title) {
        this.color = color
        this.description = description
    }

    fun addField(key : String, value : String) {
        field.add(FieldObject(key, value, inLine))
    }

    fun build() : EmbedBuilder {
        val embed = EmbedBuilder()
        embed.title = title
        embed.color = color

        if(description != null) {
            embed.description = "$description"
        }
        if(field.isNotEmpty()) {
            for(f in field) {
                embed.fields.add(f.build())
            }
        }
        if(thumbnail != null) {
            val embedThumbnail = EmbedBuilder.Thumbnail()
            embedThumbnail.url = thumbnail!!
            embed.thumbnail = embedThumbnail
        }
        embed.footer = footer!!.build()
        embed.author = author!!.build()
        embed.image = image

        return embed
    }
}