package src.main.com.stslex.wedk.commands.common

import com.github.kotlintelegrambot.dispatcher.handlers.CommandHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.KeyboardReplyMarkup
import src.main.com.stslex.wedk.commands.core.Command
import src.main.com.stslex.wedk.commands.main.MainMenuCommand

enum class CommonCommand(
    override val commandName: String
) : Command {
    RETURN_TO_MAIN("return_to_main"),
}

fun CommandHandlerEnvironment.processCommonCommand(
    command: CommonCommand
) {
    bot.sendMessage(ChatId.fromId(message.chat.id), text = "${command.commandName} command is processing")

    when (command) {
        CommonCommand.RETURN_TO_MAIN -> openMainMenu()
    }
}

fun CommandHandlerEnvironment.openMainMenu() {
    val keyboard = KeyboardReplyMarkup.createSimpleKeyboard(
        keyboard = listOf(MainMenuCommand.entries.map { it.command }),
        resizeKeyboard = true,
    )
    bot.sendMessage(
        chatId = ChatId.fromId(message.chat.id),
        text = "Welcome! Choose an option:",
        replyMarkup = keyboard
    )
}
