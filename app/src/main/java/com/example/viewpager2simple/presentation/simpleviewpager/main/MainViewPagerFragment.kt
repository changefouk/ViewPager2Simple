package com.example.viewpager2simple.presentation.simpleviewpager.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager2simple.R
import com.example.viewpager2simple.presentation.simpleviewpager.model.MainViewPagerDataModel
import kotlinx.android.synthetic.main.fragment_main_pager.*
import org.koin.android.ext.android.inject

class MainViewPagerFragment : Fragment(), MainViewPagerContract.View {

    private var data: MainViewPagerDataModel? = null
    private var position: Int = 0

    private val presenter: MainViewPagerContract.Presenter by inject()

    companion object {

        private const val ARG_DATA = "viewpager_data"
        private const val ARG_POSITION = "viewpager_position"

        @JvmStatic
        fun newInstance(data: MainViewPagerDataModel, position: Int) =
                MainViewPagerFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_DATA, data)
                        putInt(ARG_POSITION, position)
                    }
                }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            data = it.getParcelable(ARG_DATA)
            position = it.getInt(ARG_POSITION, 0)
        }
        presenter.subscribe(this)
        initView()
    }

    override fun updateNameView(value: String) {
        tv_pager.text = value
    }

    private fun initView() {
        data?.let {
            presenter.getNameView(it, position)
        }
    }

}