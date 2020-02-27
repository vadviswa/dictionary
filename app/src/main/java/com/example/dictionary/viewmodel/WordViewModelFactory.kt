package com.example.dictionary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dictionary.network.WordRepository
import javax.inject.Inject

class WordViewModelFactory @Inject constructor(val userRepository: WordRepository) :
    ViewModelProvider.Factory {
    
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WordViewModel(userRepository) as T;
    }
}