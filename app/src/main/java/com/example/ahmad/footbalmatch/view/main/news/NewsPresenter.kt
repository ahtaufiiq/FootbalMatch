package com.example.ahmad.footbalmatch.view.main.news

import android.util.Log
import com.example.ahmad.footbalmatch.data.repository.FootballRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsPresenter(private val mView: NewsContract.View, private val footballRepositoryImpl: FootballRepositoryImpl) : NewsContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getNews(category: String) {
        compositeDisposable.add(footballRepositoryImpl.getNews(category)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        {
                            mView.setData(it.articles)
                        }, { error ->
                    Log.e("Error", error.message)
                })
        )
    }
}