package com.jess.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerFragmentAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val fragments = mutableListOf<PagerData>()
    val list: List<PagerData> get() = fragments

    fun add(pagerData: PagerData) {
        fragments.add(pagerData)
    }

    fun remove(position: Int) {
        fragments.removeAt(position)
    }

    fun clear() {
        fragments.clear()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position].fragment
    }

    data class PagerData(
        val title: String,
        val fragment: Fragment
    )
}