package br.com.fiap.hodestito.roomwordsample

import android.app.Application
import br.com.fiap.hodestito.roomwordsample.di.dbModule
import br.com.fiap.hodestito.roomwordsample.di.repositoryModule
import br.com.fiap.hodestito.roomwordsample.di.uiModule
import br.com.fiap.hodestito.roomwordsample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin  {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                    uiModule,
                    dbModule
                )
            )
        }
    }
}