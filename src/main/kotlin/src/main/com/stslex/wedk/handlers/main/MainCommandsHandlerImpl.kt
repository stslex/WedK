package src.main.com.stslex.wedk.handlers.main

import com.github.kotlintelegrambot.dispatcher.handlers.CommandHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.KeyboardReplyMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import src.main.com.stslex.wedk.handlers.callbacks.InviteVariants
import src.main.com.stslex.wedk.handlers.common.CommonCommand
import src.main.com.stslex.wedk.handlers.common.openMainMenu
import src.main.com.stslex.wedk.utils.AppDispatcher

class MainCommandsHandlerImpl(
    private val dispatcher: AppDispatcher
) : MainCommandsHandler {

    override operator fun invoke() {
        MainMenuCommand.entries.forEach { commandEntry ->
            dispatcher.command(commandEntry) { command ->
                processCommand(command)
            }
        }
    }

    private fun CommandHandlerEnvironment.processCommand(
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
}