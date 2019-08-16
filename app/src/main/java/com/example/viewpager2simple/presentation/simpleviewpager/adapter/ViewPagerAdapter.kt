package com.example.viewpager2simple.presentation.simpleviewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager2simple.presentation.simpleviewpager.main.MainViewPagerFragment
import com.example.viewpager2simple.presentation.simpleviewpager.model.MainViewPagerDataModel

class ViewPagerAdapter(
        private val data: MutableList<MainViewPagerDataModel>,
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = data.size

    override fun createFragment(position: Int): Fragment {
        return MainViewPagerFragment
                .newInstance(
                        data = data[position],
                        position = position)
    }

}