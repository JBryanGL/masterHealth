package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class visorMusic2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visor_music2)

        val visor = findViewById<WebView>(R.id.webMusic2)

        visor.webChromeClient = object: WebChromeClient(){

        }
        visor.webViewClient= object: WebViewClient(){

        }

        val settings: WebSettings = visor.settings
        settings.javaScriptEnabled = true

        visor.loadUrl("https://open.spotify.com/")
    }
}