package src.main.com.stslex.wedk.handlers.common

import com.github.kotlintelegrambot.dispatcher.handlers.CommandHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId
import src.main.com.stslex.wedk.utils.AppDispatcher

class CommonCommandsHandlerImpl(
    private val dispatcher: AppDispatcher
) : CommonCommandsHandler {

    override fun invoke() {
        CommonCommand.entries.forEach { command ->
            dispatcher.command(command) {
                processCommonCommand(it)
            }
        }
    }

    private fun CommandHandlerEnvironment.processCommonCommand(
        command: CommonCommand
    ) {
        bot.sendMessage(ChatId.fromId(message.chat.id), text = "${command.commandName} command is processing")

        when (command) {
            CommonCommand.RETURN_TO_MAIN -> openMainMenu()
        }
    }
}