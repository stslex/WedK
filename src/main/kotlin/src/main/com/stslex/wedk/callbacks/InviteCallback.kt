package src.main.com.stslex.wedk.callbacks

import com.github.kotlintelegrambot.dispatcher.handlers.CallbackQueryHandlerEnvironment
import com.github.kotlintelegrambot.entities.ChatId

fun CallbackQueryHandlerEnvironment.inviteCallbackQuery() {
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