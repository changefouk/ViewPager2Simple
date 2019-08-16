package com.example.viewpager2simple.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2simple.R
import com.example.viewpager2simple.presentation.simpleviewpager.adapter.SubPagerAdapter
import com.example.viewpager2simple.presentation.simpleviewpager.adapter.ViewPagerAdapter
import com.example.viewpager2simple.presentation.simpleviewpager.model.MainViewPagerDataModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var oldSelected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        initViewPager()
    }

    private fun initViewPager() {
        val data = mutableListOf<MainViewPagerDataModel>().also {
            it.add(MainViewPagerDataModel("Account", 0))
            it.add(MainViewPagerDataModel("Account", 0))
            it.add(MainViewPagerDataModel("Credit", 1))
            it.add(MainViewPagerDataModel("Credit", 1))
            it.add(MainViewPagerDataModel("Account", 0))
        }
        val mainPager = ViewPagerAdapter(data, supportFragmentManager, lifecycle)
        root_viewpager.adapter = mainPager
        indicator.count = data.size

        val subPager = SubPagerAdapter(data, supportFragmentManager, lifecycle)
        sub_viewpager.adapter = subPager
        sub_viewpager.isUserInputEnabled = false

        root_viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                indicator.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                indicator.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator.onPageSelected(position)
                selectedSubPager(position)
            }

            private fun selectedSubPager(position: Int) {
                if (data[oldSelected].type == data[position].type) {
                    sub_viewpager.setCurrentItem(position, false)
                } else {
                    sub_viewpager.setCurrentItem(position, true)
                }
                oldSelected = position
            }
        })
    }
}