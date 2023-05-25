package com.example.bottomnav

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    val data = MutableLiveData<String>()

    private val _homeData = MutableLiveData<String>()
    val homeData : MutableLiveData<String>
        get() = _homeData

    fun getHomeData(data:String) {
       _homeData.value=data
    }
}