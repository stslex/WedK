package src.main.com.stslex.wedk.utils

import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.callbackQuery
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.handlers.CallbackQueryHandlerEnvironment
import com.github.kotlintelegrambot.dispatcher.handlers.CommandHandlerEnvironment
import src.main.com.stslex.wedk.handlers.Command

class AppDispatcher(
    private val dispatcher: Lazy<Dispatcher>
) {

    fun <C : Command> command(
        command: C,
        process: CommandHandlerEnvironment.(C) -> Unit
    ) {
        dispatcher.value.command(command.commandName) {
            process(command)
        }
    }

    fun callbackQuery(
        process: CallbackQueryHandlerEnvironment.() -> Unit
    ) {
        dispatcher.value.callbackQuery {
            process()
        }
    }
}