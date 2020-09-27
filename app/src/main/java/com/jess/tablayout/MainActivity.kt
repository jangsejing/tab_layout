package com.jess.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jess.tablayout.common.adapter.PagerFragmentAdapter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = activityInjector

    private val pagerAdapter by lazy {
        PagerFragmentAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        vp_main.run {
            adapter = pagerAdapter.apply {
                add(PagerFragmentAdapter.PagerData("tab1", Tab1Fragment()))
                add(PagerFragmentAdapter.PagerData("tab2", Tab2Fragment()))
            }
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        tl_main.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

        })

        TabLayoutMediator(tl_main, vp_main) { tab, position ->
            tab.text = pagerAdapter.list[position].title
        }.attach()
    }
}

