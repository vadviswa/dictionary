package com.example.dictionary.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    private val BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com"

    @Provides
    fun getService(): UrbanDictionaryService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UrbanDictionaryService::class.java);
    }
}