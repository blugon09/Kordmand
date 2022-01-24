package kr.blugon.command

import dev.kord.core.Kord
import dev.kord.core.behavior.channel.MessageChannelBehavior
import dev.kord.core.entity.Message
import dev.kord.core.entity.User
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on

fun Kord.createCommand(prefix : Char, command : ArrayList<String>, commandEvent : suspend CommandEvent.()->Unit) {
    val kord = this
    kord.on<MessageCreateEvent> {
        val user = message.author ?: return@on
        val channel = message.channel

        try {
            if (message.content[0] != prefix) return@on
        } catch (_: StringIndexOutOfBoundsException) {
        }
        if (user.isBot) return@on

        val args = ArrayList<String>()
        for (i in message.content.replace(prefix.toString(), "").split(" ")) {
            args.add(i)
        }
        val cmd = args[0]
        args.removeAt(0)

        if (!command.contains(cmd)) return@on
        commandEvent(CommandEvent(cmd, args, user, message, channel))
    }
}

fun Kord.createCommand(prefix : Char, command : ArrayList<String>, argsSize : Int, argsType : Int, commandEvent : suspend CommandEvent.()->Unit, argsEvent : suspend ArgsEvent.()->Unit) {
    val kord = this
    kord.on<MessageCreateEvent> {
        val user = message.author ?: return@on
        val channel = message.channel

        try {
            if (message.content[0] != prefix) return@on
        } catch (_: StringIndexOutOfBoundsException) {
        }
        if (user.isBot) return@on

        val args = ArrayList<String>()
        for (i in message.content.replace(prefix.toString(), "").split(" ")) {
            args.add(i)
        }
        val cmd = args[0]
        args.removeAt(0)

        if (!command.contains(cmd)) return@on
        if(argsType == ArgsType.EQUALS && argsSize != args.size) {
            argsEvent(ArgsEvent(cmd, args, user, message, channel))
            return@on
        }
        if(argsType == ArgsType.LESS_THAN && argsSize >= args.size) {
            argsEvent(ArgsEvent(cmd, args, user, message, channel))
            return@on
        }
        if(argsType == ArgsType.GREATER_THAN && argsSize <= args.size) {
            argsEvent(ArgsEvent(cmd, args, user, message, channel))
            return@on
        }
        if(argsType == ArgsType.IS_LESS_THAN_EQUAL_TO && args.size > argsSize) {
            argsEvent(ArgsEvent(cmd, args, user, message, channel))
            return@on
        }
        if(argsType == ArgsType.IS_GREATER_THAN_EQUAL_TO && args.size < argsSize) {
            argsEvent(ArgsEvent(cmd, args, user, message, channel))
            return@on
        }

        commandEvent(CommandEvent(cmd, args, user, message, channel))
    }
}

class CommandEvent(val command : String, val args : ArrayList<String>, val user : User, val message : Message, val channel : MessageChannelBehavior)
class ArgsEvent(val command : String, val args : ArrayList<String>, val user : User, val message : Message, val channel : MessageChannelBehavior)

object ArgsType {
    val EQUALS = 0
    val LESS_THAN = 1
    val GREATER_THAN = 2
    val IS_LESS_THAN_EQUAL_TO = 3
    val IS_GREATER_THAN_EQUAL_TO = 4
}