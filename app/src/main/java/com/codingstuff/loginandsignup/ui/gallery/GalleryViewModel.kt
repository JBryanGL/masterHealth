package com.codingstuff.loginandsignup.ui.gallery

import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.codingstuff.loginandsignup.R

class GalleryViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {

    }
    val text: LiveData<String> = _text

}
