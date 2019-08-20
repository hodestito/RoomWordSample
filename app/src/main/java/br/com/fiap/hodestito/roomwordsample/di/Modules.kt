package br.com.fiap.hodestito.roomwordsample.di

import androidx.room.Room
import br.com.fiap.hodestito.roomwordsample.WordListAdapter
import br.com.fiap.hodestito.roomwordsample.WordViewModel
import br.com.fiap.hodestito.roomwordsample.dao.WordRoomDatabase
import br.com.fiap.hodestito.roomwordsample.repository.WordRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single {
        WordRepository(get())
    }
}

val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single {
        get<WordRoomDatabase>().wordDao()
    }
}

val uiModule = module {

    factory {
        WordListAdapter(get())
    }
}

val viewModelModule = module {
    viewModel { WordViewModel(get(), get()) }
}