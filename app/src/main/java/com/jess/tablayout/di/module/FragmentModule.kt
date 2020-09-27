package com.jess.tablayout.di.module

import com.jess.tablayout.Tab1Fragment
import com.jess.tablayout.Tab2Fragment
import com.jess.tablayout.di.annotaion.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author jess
 * @since 2020.06.12
 */
@Module
abstract class FragmentModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindTab1Fragment(): Tab1Fragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindTab2Fragment(): Tab2Fragment

}