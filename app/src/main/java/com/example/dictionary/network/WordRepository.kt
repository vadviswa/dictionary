package com.example.dictionary.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dictionary.model.UrbanDictionaryResponse
import com.example.dictionary.model.Word
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WordRepository @Inject constructor(var userDataService: UrbanDictionaryService) {

    private val TAG: String = WordRepository::class.java.getSimpleName()


    fun searchDictionary(searchTerm: String?): LiveData<ArrayList<Word>> {
        val mutableLiveData: MutableLiveData<ArrayList<Word>> = MutableLiveData()
        val headers = mutableMapOf<String, String>()

        headers["x-rapidapi-host"] = "mashape-community-urban-dictionary.p.rapidapi.com"
        headers["x-rapidapi-key"] = "K7ErDAJYRrmshNJoDKcCG0dXCQSdp1zngGnjsnQc2wBwXqWoOV"
        val call: Call<UrbanDictionaryResponse> =
            userDataService.getSearchWord(headers, searchTerm)
        call.enqueue(object : Callback<UrbanDictionaryResponse?> {
            override fun onResponse(
                call: Call<UrbanDictionaryResponse?>,
                response: Response<UrbanDictionaryResponse?>
            ) {
                val dictionaryResponse: UrbanDictionaryResponse? = response.body()
                if (dictionaryResponse != null && dictionaryResponse.words != null) {
                    val words: ArrayList<Word> = dictionaryResponse.words
                    mutableLiveData.setValue(words)
                }
            }

            override fun onFailure(call: Call<UrbanDictionaryResponse?>, t: Throwable) {
                Log.e(TAG, t.message)
            }
        })
        return mutableLiveData
    }
}