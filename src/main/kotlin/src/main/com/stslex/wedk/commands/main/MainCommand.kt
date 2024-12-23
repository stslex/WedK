package src.main.com.stslex.wedk.commands.main

import com.github.kotlintelegrambot.dispatcher.handlers.CommandHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.KeyboardReplyMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import src.main.com.stslex.wedk.callbacks.InviteVariants
import src.main.com.stslex.wedk.commands.common.CommonCommand
import src.main.com.stslex.wedk.commands.common.openMainMenu
import src.main.com.stslex.wedk.commands.core.Command

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

fun CommandHandlerEnvironment.processCommand(
    command: MainMenuCommand
) {
    bot.sendMessage(ChatId.fromId(message.chat.id), text = "${command.commandName} command is processing")

    when (command) {
        MainMenuCommand.START -> openMainMenu()

        MainMenuCommand.HELP -> {
            val keyboard = KeyboardReplyMarkup.createSimpleKeyboard(
                keyboard = listOf(CommonCommand.entries.map { it.command }),
                resizeKeyboard = true,
            )
            bot.sendMessage(
                chatId = ChatId.fromId(message.chat.id),
                text = "help message",
                replyMarkup = keyboard
            )
        }

        MainMenuCommand.ALL_INFO -> Unit

        MainMenuCommand.INVITE -> {
            val keyboard = InlineKeyboardMarkup.createSingleRowKeyboard(
                InlineKeyboardButton.CallbackData(
                    text = InviteVariants.INVITE_YES.variantName,
                    callbackData = InviteVariants.INVITE_YES.callbackName
                ),
                InlineKeyboardButton.CallbackData(
                    text = InviteVariants.INVITE_NO.variantName,
                    callbackData = InviteVariants.INVITE_NO.callbackName
                ),
            )
            bot.sendMessage(
                chatId = ChatId.fromId(message.chat.id),
                text = "invite message",
                replyMarkup = keyboard
            )
        }

        MainMenuCommand.DATE -> Unit

        MainMenuCommand.LOCATION -> Unit
    }
}