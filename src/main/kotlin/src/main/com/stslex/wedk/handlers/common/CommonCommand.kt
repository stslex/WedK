package src.main.com.stslex.wedk.handlers.common

import com.github.kotlintelegrambot.dispatcher.handlers.CommandHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.KeyboardReplyMarkup
import src.main.com.stslex.wedk.handlers.Command
import src.main.com.stslex.wedk.handlers.main.MainMenuCommand

enum class CommonCommand(
    override val commandName: String
) : Command {
    RETURN_TO_MAIN("return_to_main"),
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
