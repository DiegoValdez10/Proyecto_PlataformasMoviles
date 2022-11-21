 package com.example.proyecto.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import com.example.proyecto.R
import kotlinx.android.synthetic.main.activity_news_details.*

 class NewsDetailsActivity : AppCompatActivity() {

     lateinit var dialog: AlertDialog

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_news_details)


         dialog.show()

         /*WebView*/
         webView.settings.javaScriptEnabled = true
         webView.webChromeClient = WebChromeClient()
         webView.webViewClient = object : WebViewClient() {
             override fun onPageFinished(view: WebView?, url: String?) {
                 dialog.dismiss()
             }
         }

         if (intent != null) {
             if (!intent.getStringExtra("webURL")?.isEmpty()!!) {
                 webView.loadUrl(intent.getStringExtra("webURL").toString())
             }
         }
     }
 }