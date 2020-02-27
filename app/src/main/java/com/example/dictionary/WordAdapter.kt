package com.example.dictionary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList
import androidx.recyclerview.widget.SortedListAdapterCallback
import com.example.dictionary.databinding.WordViewBinding
import com.example.dictionary.model.Word
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class WordAdapter @Inject constructor() : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    private var wordList: ArrayList<Word>

    init {
        wordList = ArrayList()
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = wordList[position]
        holder.wordViewBinding.word = current
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val wordViewBinding: WordViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.word_view,
            parent,
            false
        )
        return WordViewHolder(wordViewBinding)
    }

    fun addWords(words: List<Word>) {
        wordList.clear()
        wordList.addAll(words)
    }

    fun sortLikesAscending() {
        wordList.sortWith(Comparator { first: Word, second: Word ->
            val one = first?.thumbsUp?.toInt() ?: 0
            val two = second?.thumbsUp?.toInt() ?: 0
            two - one
        })
        notifyDataSetChanged()
    }

    fun sortLikesDescending() {
        wordList.sortWith(Comparator { first: Word, second: Word ->
            val one = first?.thumbsDown?.toInt() ?: 0
            val two = second?.thumbsDown?.toInt() ?: 0
            two - one
        })
        notifyDataSetChanged()
    }

    class WordViewHolder constructor(val wordViewBinding: WordViewBinding) :
        RecyclerView.ViewHolder(wordViewBinding.root) {
    }
}