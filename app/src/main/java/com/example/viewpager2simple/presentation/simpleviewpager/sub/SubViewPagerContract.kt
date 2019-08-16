package com.example.viewpager2simple.presentation.simpleviewpager.sub

import com.example.viewpager2simple.presentation.simpleviewpager.model.MainViewPagerDataModel

interface SubViewPagerContract {

    interface View {
        fun updateTypeMenu(value: String)
    }

    interface Presenter {
        fun subscribe(view: View)
        fun unSubscribe()
        fun getTypeMenu(data: MainViewPagerDataModel, position: Int)
    }

}