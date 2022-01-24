package kr.blugon.embed

import dev.kord.rest.builder.message.EmbedBuilder

class FieldObject(val name : String, val value : String, val inLine : Boolean) {

    fun build() : EmbedBuilder.Field {
        val field = EmbedBuilder.Field()
        field.name = name
        field.value = value
        if(field.name == "" || field.name == " ") {
            field.name = "️"
        }
        if(field.value == "" || field.value == " ") {
            field.value = "️"
        }
        field.inline = inLine

        return field
    }
}