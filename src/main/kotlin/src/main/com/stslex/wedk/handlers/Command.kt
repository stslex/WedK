package src.main.com.stslex.wedk.handlers

interface Command {

    val commandName: String

    val command: String
        get() = "/$commandName"
}