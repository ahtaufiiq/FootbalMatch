package com.example.ahmad.footbalmatch.view.main.news.webView

import android.graphics.Bitmap
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.ahmad.footbalmatch.R
import kotlinx.android.synthetic.main.activity_web_view.*
import android.webkit.WebResourceRequest



class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url:String = intent.getStringExtra("url")

        webView.webViewClient = MyWebViewClient()
        webView.loadUrl(url)

    }



    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            progressBar.visibility = View.VISIBLE
        }
    }

    fun setValue(progress: Int) {
        this.progressBar.setProgress(progress)
    }
}
