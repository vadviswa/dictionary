package com.example.dictionary

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.dictionary.model.Word
import com.example.dictionary.network.WordRepository
import com.example.dictionary.viewmodel.WordViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.util.*
import kotlin.collections.ArrayList

@RunWith(JUnit4::class)
class WordViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var wordRepository: WordRepository

    @Mock
    lateinit var observer: Observer<ArrayList<Word>>

    lateinit var wordViewModel: WordViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.wordViewModel = WordViewModel(wordRepository)
    }

    @Test
    fun fetchUserRepositories_positiveResponse() {
        val mockResult: MutableLiveData<ArrayList<Word>> = MutableLiveData()
        val word = Word()
        word.id = "1"
        word.author = "test"
        mockResult.value = arrayListOf(word)
        `when`(this.wordRepository.searchDictionary(anyString())).thenReturn(mockResult)

        var result =
            wordViewModel.getAllWords(ArgumentMatchers.anyString()).observeForever(observer)

        assertNotNull(result)
    }
}