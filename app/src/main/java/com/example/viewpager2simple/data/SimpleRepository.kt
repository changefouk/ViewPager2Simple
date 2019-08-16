package com.example.viewpager2simple.data

interface SimpleRepository {
    fun getPageNumber(number: Int): String
}

class SimpleRepositoryImpl() : SimpleRepository {

    override fun getPageNumber(number: Int) = "this page number $number"

}