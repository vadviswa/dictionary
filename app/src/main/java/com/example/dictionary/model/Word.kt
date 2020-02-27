package com.example.dictionary.model

import com.google.gson.annotations.SerializedName

class Word {

    var definition: String? = null
    var word: String? = null

    @SerializedName("id")
    var id: String? = null

    var author: String? = null

    var permalink: String? = null

    @SerializedName("thumbs_down")
    var thumbsDown: String? = null

    @SerializedName("thumbs_up")
    var thumbsUp: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Word

        if (definition != other.definition) return false
        if (word != other.word) return false
        if (id != other.id) return false
        if (author != other.author) return false
        if (permalink != other.permalink) return false
        if (thumbsDown != other.thumbsDown) return false
        if (thumbsUp != other.thumbsUp) return false

        return true
    }

    override fun hashCode(): Int {
        var result = definition?.hashCode() ?: 0
        result = 31 * result + (word?.hashCode() ?: 0)
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (author?.hashCode() ?: 0)
        result = 31 * result + (permalink?.hashCode() ?: 0)
        result = 31 * result + (thumbsDown?.hashCode() ?: 0)
        result = 31 * result + (thumbsUp?.hashCode() ?: 0)
        return result
    }
}