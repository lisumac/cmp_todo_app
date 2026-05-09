package org.rdk.todo.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.rdk.todo.navigation.Navigator



val koinModule = module {
    singleOf(::Navigator)
}


fun initializeKoin(
    config: (KoinApplication. () -> Unit)? = null
) {
    startKoin {
        config?.invoke(this)
        modules(koinModule, )
    }
}