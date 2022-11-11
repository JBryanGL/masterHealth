package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class visorMusic1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visor_music1)

        val visor = findViewById<WebView>(R.id.webMusic)

        visor.webChromeClient = object: WebChromeClient(){

        }
        visor.webViewClient= object: WebViewClient(){

        }

        val settings: WebSettings = visor.settings
        settings.javaScriptEnabled = true

        visor.loadUrl("https://music.youtube.com/")
    }
}