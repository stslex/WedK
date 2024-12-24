package src.main.com.stslex.wedk.utils

import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE
import co.touchlab.kermit.Logger as KLogger

object KoinLogger : Logger() {

    private const val TAG = "Koin"

    override fun display(level: Level, msg: MESSAGE) {
        when (level) {
            Level.DEBUG -> KLogger.d(messageString = msg, tag = TAG)
            Level.INFO -> KLogger.i(messageString = msg, tag = TAG)
            Level.ERROR -> KLogger.e(messageString = msg, tag = TAG)
            Level.WARNING -> KLogger.w(messageString = msg, tag = TAG)
            Level.NONE -> KLogger.v(messageString = msg, tag = TAG)
        }
    }
}