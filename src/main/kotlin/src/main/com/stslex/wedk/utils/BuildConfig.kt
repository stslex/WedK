package src.main.com.stslex.wedk.utils

import io.github.cdimascio.dotenv.dotenv

object BuildConfig {


    private const val TELEGRAM_BOT_KEY = "TELEGRAM_BOT_TOKEN"
    private const val IS_RELEASE_KEY = "IS_RELEASE"

    private val dotenv by lazy { dotenv() }

    val telegramToken: String by lazy {
        dotenv.get(TELEGRAM_BOT_KEY)
    }

    val isRelease: Boolean by lazy {
        dotenv.get(IS_RELEASE_KEY) == "true"
    }
}

