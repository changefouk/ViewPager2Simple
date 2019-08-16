package com.example.viewpager2simple.presentation.simpleviewpager.main

import com.example.viewpager2simple.presentation.simpleviewpager.model.MainViewPagerDataModel

interface MainViewPagerContract {

    interface View {
        fun updateNameView(value: String)
    }

    interface Presenter {
        fun subscribe(view: View)
        fun unSubscribe()
        fun getNameView(data: MainViewPagerDataModel, position: Int)
    }

}