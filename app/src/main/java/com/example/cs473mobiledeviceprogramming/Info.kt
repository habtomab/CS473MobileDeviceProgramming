package com.example.cs473mobiledeviceprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.cs473mobiledeviceprogramming.R

class Info : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        webView = findViewById(R.id.wv2) as WebView
        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled = true
       // webView.loadUrl("file:///android_asset/info");
        webView.loadUrl("https://github.com/habtomab/MobileAppSln/blob/master/Corse_Info/course_info.pdf")
    }
}