package com.jess.tablayout.di

import com.jess.tablayout.JessApplication
import com.jess.tablayout.di.module.ActivityModule
import com.jess.tablayout.di.module.FragmentModule
import com.jess.tablayout.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author jess
 * @since 2020.06.12
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent : AndroidInjector<JessApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: JessApplication): AppComponent
    }
}