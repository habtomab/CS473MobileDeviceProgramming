package com.example.cs473mobiledeviceprogramming

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.cs473mobiledeviceprogramming.Model.PdfModel
import com.github.barteksc.pdfviewer.PDFView
import kotlinx.android.synthetic.main.activity_pdf.*

class PdfActivity : AppCompatActivity() {
      private lateinit var webView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)
        webView= findViewById(R.id.wv1)as WebView
        webView.webViewClient= WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled=true
        val pdfmodel = intent.getSerializableExtra("product") as PdfModel
        Log.d("RAW",pdfmodel.pdfUrl)
       //val url = "http://www.pdf995.com/samples/pdf.pdf"
        webView.loadUrl(pdfmodel.pdfUrl)



    }
}
