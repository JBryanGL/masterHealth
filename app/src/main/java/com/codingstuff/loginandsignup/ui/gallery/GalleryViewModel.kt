package com.codingstuff.loginandsignup.ui.gallery

import android.content.Intent
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingstuff.loginandsignup.Home
import com.codingstuff.loginandsignup.R
import com.codingstuff.loginandsignup.SignInActivity
import com.codingstuff.loginandsignup.StartupActivity

class GalleryViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"

    }
    val text: LiveData<String> = _text

}
