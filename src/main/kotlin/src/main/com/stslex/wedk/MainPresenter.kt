package src.main.com.stslex.wedk

import src.main.com.stslex.wedk.handlers.callbacks.CallbacksHandler
import src.main.com.stslex.wedk.handlers.common.CommonCommandsHandler
import src.main.com.stslex.wedk.handlers.main.MainCommandsHandler

class MainPresenter(
    private val mainCommandsHandler: MainCommandsHandler,
    private val commonCommandsHandler: CommonCommandsHandler,
    private val callbacksHandler: CallbacksHandler
) {

    fun setupMainHandler() {
        mainCommandsHandler()
    }

    fun setupCommonHandlers() {
        commonCommandsHandler()
    }

    fun setupCallbacks() {
        callbacksHandler()
    }

}