package com.example.bottomnav

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel() : ViewModel() {

    private val _country = MutableLiveData("in")
    val country: MutableLiveData<String> = _country
    fun setCountry(data: String) {
        _country.value = data
    }


    private val _url = MutableLiveData<String>()
    val url: MutableLiveData<String> = _url

    fun setUrl(data: String) {
        _url.value = data
    }
}