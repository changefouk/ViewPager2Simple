package com.example.viewpager2simple.presentation.simpleviewpager.sub

import com.example.viewpager2simple.presentation.simpleviewpager.model.MainViewPagerDataModel

class SubViewPagerPresenterImpl() : SubViewPagerContract.Presenter {

    private var view: SubViewPagerContract.View? = null

    override fun subscribe(view: SubViewPagerContract.View) {
        this.view = view
    }

    override fun getTypeMenu(data: MainViewPagerDataModel, position: Int) {
        view?.updateTypeMenu(
                if (data.type == 0) "Account Menu "
                else "Credit Menu ")
    }

    override fun unSubscribe() {
        view = null
    }

}


