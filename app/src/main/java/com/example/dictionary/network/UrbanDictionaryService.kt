package com.example.dictionary.network

import com.example.dictionary.model.UrbanDictionaryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query


interface UrbanDictionaryService {
    @GET("/define")
    fun getSearchWord(@HeaderMap headers: Map<String, String>, @Query("term") term: String?): Call<UrbanDictionaryResponse>
}