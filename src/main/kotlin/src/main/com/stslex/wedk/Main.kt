package src.main.com.stslex.wedk

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.logging.LogLevel
import src.main.com.stslex.wedk.utils.BuildConfig

fun main() {
    launchKoinBot { presenter ->
        val bot = bot {
            token = BuildConfig.telegramToken
            logLevel = if (BuildConfig.isRelease) LogLevel.Error else LogLevel.All()

            dispatch {
                modules(dispatcherModule(this))

                presenter.setupMainHandler()
                presenter.setupCommonHandlers()
                presenter.setupCallbacks()
            }
        }
        bot.startPolling()
    }
}

