package com.example.bottomnav

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel() : ViewModel() {

    private val _country = MutableLiveData("in")
    val country: MutableLiveData<String> = _country

    private val _url = MutableLiveData<String>()
    val url: MutableLiveData<String> = _url

    fun setCountry(data: String) {
        _country.value = data
    }

    fun setUrl(data: String) {
        _url.value = data
    }
}