package com.vama.assessment.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _imageUrlStrings = MutableLiveData<List<String>>()
    val imageUrlStrings: LiveData<List<String>> = _imageUrlStrings

    init {
        var urlStrings: List<String> = emptyList()
        for(i in 0..99) {
            urlStrings = if (i == 97) {
                urlStrings + ""
            } else {
                urlStrings + ("https://dummyimage.com/600x400/000/fff&text=${i+1}")
            }
        }
        _imageUrlStrings.postValue(urlStrings)
    }
}