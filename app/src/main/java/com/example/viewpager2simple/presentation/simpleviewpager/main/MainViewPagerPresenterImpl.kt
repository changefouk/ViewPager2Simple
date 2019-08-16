package com.example.viewpager2simple.presentation.simpleviewpager.main

import com.example.viewpager2simple.data.SimpleRepository
import com.example.viewpager2simple.presentation.simpleviewpager.model.MainViewPagerDataModel

class MainViewPagerPresenterImpl(
        private val repository: SimpleRepository
) : MainViewPagerContract.Presenter {

    private var view: MainViewPagerContract.View? = null

    override fun subscribe(view: MainViewPagerContract.View) {
        this.view = view
    }

    override fun getNameView(data: MainViewPagerDataModel, position: Int) {
        view?.updateNameView("${data.accountNumber} \n ${repository.getPageNumber(position)}")
    }

    override fun unSubscribe() {
        view = null
    }

}


