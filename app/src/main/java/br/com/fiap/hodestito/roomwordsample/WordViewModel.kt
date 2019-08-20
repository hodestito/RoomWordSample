package br.com.fiap.hodestito.roomwordsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.fiap.hodestito.roomwordsample.dao.WordDao
import br.com.fiap.hodestito.roomwordsample.dao.WordRoomDatabase
import br.com.fiap.hodestito.roomwordsample.model.Word
import br.com.fiap.hodestito.roomwordsample.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application, wordDao: WordDao) : AndroidViewModel(application) {

    private val repository: WordRepository = WordRepository(wordDao)
    val allWords: LiveData<List<Word>> = repository.allWords

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }
}