package com.example.dictionary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.model.Word
import com.example.dictionary.network.WordRepository
import javax.inject.Inject

class WordViewModel @Inject constructor(val wordRepository: WordRepository) : ViewModel() {

    fun getAllWords(searchTerm: String?): LiveData<ArrayList<Word>> {
        return wordRepository.searchDictionary(searchTerm)
    }
}