package kr.blugon.kordmand.message

import dev.kord.core.behavior.channel.MessageChannelBehavior
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.behavior.reply
import dev.kord.core.entity.Message
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.rest.builder.message.AllowedMentionsBuilder
import dev.kord.rest.builder.message.EmbedBuilder

object Reply {
    suspend fun MessageChannelBehavior.createMessage(embed : EmbedBuilder) {
        this.createMessage {
            embeds.add(embed)
            val mention = AllowedMentionsBuilder()
            mention.repliedUser = false
        }
    }
    suspend fun MessageChannel.createMessage(embed : EmbedBuilder) {
        this.createMessage {
            embeds.add(embed)
            val mention = AllowedMentionsBuilder()
            mention.repliedUser = false
        }
    }

    suspend fun Message.reply(embed : EmbedBuilder) {
        this.reply {
            embeds.add(embed)
            val mention = AllowedMentionsBuilder()
            mention.repliedUser = false
            this.allowedMentions = mention
        }
    }
    suspend fun Message.reply(embed : EmbedBuilder, isMention : Boolean) {
        this.reply {
            embeds.add(embed)
            val mention = AllowedMentionsBuilder()
            mention.repliedUser = isMention
            this.allowedMentions = mention
        }
    }

    suspend fun Message.reply(message : String) {
        this.reply {
            content = message
            val mention = AllowedMentionsBuilder()
            mention.repliedUser = false
            this.allowedMentions = mention
        }
    }

    suspend fun Message.reply(message : String, isMention : Boolean) {
        this.reply {
            content = message
            val mention = AllowedMentionsBuilder()
            mention.repliedUser = isMention
            this.allowedMentions = mention
        }
    }
}