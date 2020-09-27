package com.jess.tablayout.di.module

import com.jess.tablayout.di.annotaion.ActivityScoped
import com.jess.tablayout.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author jess
 * @since 2020.06.12
 */
@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}