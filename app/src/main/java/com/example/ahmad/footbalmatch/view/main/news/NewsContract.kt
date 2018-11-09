package com.example.ahmad.footbalmatch.view.main.news

import com.example.ahmad.footbalmatch.data.response.News

interface NewsContract {
    interface View {
        fun setData(matchList: List<News>)
    }

    interface Presenter {
        fun getNews(category:String)
    }
}