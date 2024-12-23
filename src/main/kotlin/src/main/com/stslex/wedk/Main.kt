package src.main.com.stslex.wedk

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.callbackQuery
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import io.github.cdimascio.dotenv.dotenv
import src.main.com.stslex.wedk.callbacks.inviteCallbackQuery
import src.main.com.stslex.wedk.commands.common.CommonCommand
import src.main.com.stslex.wedk.commands.common.processCommonCommand
import src.main.com.stslex.wedk.commands.main.MainMenuCommand
import src.main.com.stslex.wedk.commands.main.processCommand

fun main() {
    val dotenv = dotenv()

    val bot = bot {
        token = dotenv["TELEGRAM_BOT_TOKEN"]
        dispatch {
            text {
                println("Received text: ${message.text}")
            }
            callbackQuery {
                inviteCallbackQuery()
            }
            MainMenuCommand.entries.forEach { commandEntry ->
                command(commandEntry.commandName) {
                    processCommand(commandEntry)
                }
            }
            CommonCommand.entries.forEach {
                command(it.commandName) {
                    processCommonCommand(it)
                }
            }
        }
    }
    bot.startPolling()
}




