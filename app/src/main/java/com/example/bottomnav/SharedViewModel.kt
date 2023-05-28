package com.example.bottomnav

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel() : ViewModel() {

    private val _homeData = MutableLiveData<String>()
    val homeData: MutableLiveData<String>
        get() = _homeData

    fun getHomeData(data: String) {
        _homeData.value = data
    }
}