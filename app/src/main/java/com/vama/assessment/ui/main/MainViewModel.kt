package com.vama.assessment.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    init {
        var urlStrings: List<String> = emptyList()
        for(i in 0..99) {
            urlStrings = if (i == 97) {
                urlStrings + ""
            } else {
                urlStrings + ("https://dummyimage.com/600x400/000/fff&text=${i+1}")
            }
        }
    }
}
