package com.example.viewpager2simple.presentation.simpleviewpager.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainViewPagerDataModel(
        var accountNumber: String? = null,
        var type: Int) : Parcelable