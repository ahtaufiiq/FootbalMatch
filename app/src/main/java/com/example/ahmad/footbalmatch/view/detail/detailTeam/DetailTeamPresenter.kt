package com.example.ahmad.footbalmatch.view.detail.detailMatch

import android.util.Log
import com.example.ahmad.footbalmatch.data.repository.FootballRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailTeamPresenter(private val mView: DetailTeamContract.View, private val footballRepositoryImpl: FootballRepositoryImpl) : DetailTeamContract.Presenter {


    private val compositeDisposable = CompositeDisposable()


    override fun getTeam(id: String) {

        compositeDisposable.add(footballRepositoryImpl.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mView.setDataEvent(it.teams[0])
                },
                { error ->
                    Log.e("Error", error.message)
                }
                )
        )
    }


}