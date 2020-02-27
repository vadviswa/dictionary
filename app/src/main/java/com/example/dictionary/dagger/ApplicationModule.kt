package com.example.dictionary.dagger

import com.example.dictionary.MainActivity
import com.example.dictionary.network.RetrofitModule
import com.example.dictionary.viewmodel.WordViewModelModule
import dagger.Component

@Component(modules = [WordViewModelModule::class, RetrofitModule::class])
interface ApplicationModule {

    fun inject(mainActivity: MainActivity)
}
