package src.main.com.stslex.wedk.commands.core

interface Command {

    val commandName: String

    val command: String
        get() = "/$commandName"
}