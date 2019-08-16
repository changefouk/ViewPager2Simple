package com.example.viewpager2simple.di

import com.example.viewpager2simple.data.SimpleRepository
import com.example.viewpager2simple.data.SimpleRepositoryImpl
import com.example.viewpager2simple.presentation.simpleviewpager.main.MainViewPagerContract
import com.example.viewpager2simple.presentation.simpleviewpager.main.MainViewPagerPresenterImpl
import com.example.viewpager2simple.presentation.simpleviewpager.sub.SubViewPagerContract
import com.example.viewpager2simple.presentation.simpleviewpager.sub.SubViewPagerPresenterImpl
import org.koin.dsl.module


val appModule = module {
    factory<MainViewPagerContract.Presenter> { MainViewPagerPresenterImpl(get()) }
    factory<SubViewPagerContract.Presenter> { SubViewPagerPresenterImpl() }
}

val repomodule = module {
    //simple repo
    single<SimpleRepository> { SimpleRepositoryImpl() }
}

val rxModule = module { }

// Gather all app modules
val myApp = listOf(appModule, repomodule)