package kr.blugon.kordmand.embed

import dev.kord.rest.builder.message.EmbedBuilder

class AuthorObject(val name : String, val url : String?, val icon : String?) {

    fun build() : EmbedBuilder.Author {
        val author = EmbedBuilder.Author()
        author.name = name
        author.url = url
        author.icon = icon

        return author
    }
}