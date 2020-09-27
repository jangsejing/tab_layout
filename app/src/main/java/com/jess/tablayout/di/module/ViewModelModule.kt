package com.jess.tablayout.di.module

import androidx.lifecycle.ViewModel
import com.jess.tablayout.di.annotaion.ViewModelKey
import com.jess.tablayout.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author jess
 * @since 2020.06.12
 */
@Module(includes = [ViewModelFactoryModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}

