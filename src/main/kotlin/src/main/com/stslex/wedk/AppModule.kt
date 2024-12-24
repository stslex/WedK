package src.main.com.stslex.wedk

import com.github.kotlintelegrambot.dispatcher.Dispatcher
import org.koin.core.KoinApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import src.main.com.stslex.wedk.handlers.callbacks.CallbacksHandler
import src.main.com.stslex.wedk.handlers.callbacks.CallbacksHandlerImpl
import src.main.com.stslex.wedk.handlers.common.CommonCommandsHandler
import src.main.com.stslex.wedk.handlers.common.CommonCommandsHandlerImpl
import src.main.com.stslex.wedk.handlers.main.MainCommandsHandler
import src.main.com.stslex.wedk.handlers.main.MainCommandsHandlerImpl
import src.main.com.stslex.wedk.utils.AppDispatcher
import src.main.com.stslex.wedk.utils.KoinLogger

fun appModule() = module {
    singleOf(::MainPresenter)
    single { AppDispatcher(lazy { get<Dispatcher>() }) }
    singleOf(::MainCommandsHandlerImpl) { bind<MainCommandsHandler>() }
    singleOf(::CommonCommandsHandlerImpl) { bind<CommonCommandsHandler>() }
    singleOf(::CallbacksHandlerImpl) { bind<CallbacksHandler>() }
}

fun dispatcherModule(dispatcher: Dispatcher) = module {
    single<Dispatcher> { dispatcher }
}

fun launchKoinBot(
    app: KoinApplication.(MainPresenter) -> Unit
) {
    koinApplication {
        logger(KoinLogger)
        modules(appModule())
        app(koin.get())
    }
}