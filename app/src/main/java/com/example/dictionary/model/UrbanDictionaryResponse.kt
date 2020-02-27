package com.example.dictionary.model

import com.google.gson.annotations.SerializedName

class UrbanDictionaryResponse {
    @SerializedName("list")
    val words: ArrayList<Word>? = null
}