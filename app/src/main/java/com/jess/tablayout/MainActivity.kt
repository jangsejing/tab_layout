package com.jess.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private val pagerAdapter by lazy {
        PagerAdapter(this)
    }

    private val tabTitleArray = arrayOf("Deck", "Info")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        vp_main.run {
            adapter = pagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        TabLayoutMediator(tl_main, vp_main) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}

