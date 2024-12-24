package src.main.com.stslex.wedk.handlers.callbacks

import com.github.kotlintelegrambot.dispatcher.handlers.CallbackQueryHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId
import src.main.com.stslex.wedk.utils.AppDispatcher

class CallbacksHandlerImpl(
    private val dispatcher: AppDispatcher
) : CallbacksHandler {

    override fun invoke() {
        dispatcher.callbackQuery {
            inviteCallbackQuery()
        }
    }

    private fun CallbackQueryHandlerEnvironment.inviteCallbackQuery() {
        when (callbackQuery.data) {
            InviteVariants.INVITE_YES.callbackName -> bot.sendMessage(
                chatId = ChatId.fromId(callbackQuery.message?.chat?.id ?: 0),
                text = "Вы приняли приглашение"
            )

            InviteVariants.INVITE_NO.callbackName -> bot.sendMessage(
                chatId = ChatId.fromId(callbackQuery.message?.chat?.id ?: 0),
                text = "Вы отклонили приглашение"
            )
        }
    }
}