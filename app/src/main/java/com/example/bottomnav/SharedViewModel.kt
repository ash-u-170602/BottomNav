package com.example.bottomnav

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel() : ViewModel() {

    private val _country = MutableLiveData("in")
    val country: MutableLiveData<String> = _country

    fun getHomeData(data: String) {
        _country.value = data
    }
}