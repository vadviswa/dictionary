package com.example.dictionary

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dictionary.dagger.MyApplication
import com.example.dictionary.databinding.ActivityMainBinding
import com.example.dictionary.model.Word
import com.example.dictionary.viewmodel.WordViewModel
import com.example.dictionary.viewmodel.WordViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    var viewBinding: ActivityMainBinding? = null

    @Inject
    lateinit var wordViewModelFactory: WordViewModelFactory

    lateinit var wordViewModel: WordViewModel

    @Inject
    lateinit var dataAdapter: WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).applicationModule.inject(this)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        wordViewModel = ViewModelProviders.of(this, wordViewModelFactory).get<WordViewModel>(
            WordViewModel::class.java
        )

        viewBinding?.recyclerView?.setAdapter(dataAdapter)

        viewBinding?.searchButton?.setOnClickListener { view ->
            viewBinding?.progressCircular?.setVisibility(View.VISIBLE)
            viewBinding?.sortDescending?.setVisibility(View.VISIBLE)
            viewBinding?.sortAscending?.setVisibility(View.VISIBLE)
            getWords(viewBinding?.searchTerm?.getText().toString())
            if (view != null) {
                val inputManager = view.context.getSystemService(
                    Context.INPUT_METHOD_SERVICE
                ) as InputMethodManager
                inputManager.hideSoftInputFromWindow(
                    view.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }
        }

        viewBinding?.sortAscending?.setOnClickListener { view ->
            dataAdapter.sortLikesAscending()
        }


        viewBinding?.sortDescending?.setOnClickListener { view ->
            dataAdapter.sortLikesDescending()
        }
    }

    private fun getWords(word: String) {
        wordViewModel.getAllWords(word)
            .observe(this, object : Observer<ArrayList<Word>> {
                override fun onChanged(words: ArrayList<Word>) {
                    dataAdapter.addWords(words)
                    dataAdapter.notifyDataSetChanged()
                    viewBinding?.progressCircular?.setVisibility(View.GONE)
                }
            })
    }
}
