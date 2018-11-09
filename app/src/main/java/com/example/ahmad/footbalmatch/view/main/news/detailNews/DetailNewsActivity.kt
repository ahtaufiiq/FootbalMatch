package com.example.ahmad.footbalmatch.view.main.news.detailNews

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ahmad.footbalmatch.R
import com.example.ahmad.footbalmatch.data.response.News
import com.example.ahmad.footbalmatch.view.main.news.webView.WebViewActivity
import kotlinx.android.synthetic.main.activity_detail2.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailNewsActivity : AppCompatActivity() {
    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)
        createToolbar()
        createActionBar()
        setData()
    }

    private fun setData() {
        val news = intent.getParcelableExtra<News>("news")
        titleNews_detail.text = news.title
        deskripsiNews_detail.text = news.content
        Glide.with(this)
                .load(news.urlToImage?:"null")
                .into(imgNews_detail)
        url = news.url?:"https://www.google.com"

        btn_read_all.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        }
    }

    private fun createToolbar() {

        setSupportActionBar(toolbar)
        if (supportActionBar != null)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun createActionBar() {
        //Action Bar
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = ""

        val window = this.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.colorPrimaryDark)
        }
    }
}
