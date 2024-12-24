package src.main.com.stslex.wedk.handlers.main

import src.main.com.stslex.wedk.handlers.Command

enum class MainMenuCommand(
    override val commandName: String
) : Command {
    START("start"),
    HELP("help"),
    ALL_INFO("all_info"),
    INVITE("invite"),
    DATE("date"),
    LOCATION("location"),
}
