package com.vama.assessment.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var imageUrlStrings: List<String> = listOf()

    init {
        for(i in 0..99) {
            imageUrlStrings = if (i == 97) {
                imageUrlStrings + ""
            } else {
                imageUrlStrings + ("https://dummyimage.com/600x400/000/fff&text=${i+1}")
            }
        }
    }
}