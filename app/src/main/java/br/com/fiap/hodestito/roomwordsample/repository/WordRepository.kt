package br.com.fiap.hodestito.roomwordsample.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import br.com.fiap.hodestito.roomwordsample.dao.WordDao
import br.com.fiap.hodestito.roomwordsample.model.Word

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}