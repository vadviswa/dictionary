package com.example.dictionary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class  WordViewModelModule {

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Binds
    @IntoMap
    @ViewModelKey(WordViewModel::class)
    abstract fun bindWordViewModel(viewModel: WordViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: WordViewModelFactory): ViewModelProvider.Factory

}