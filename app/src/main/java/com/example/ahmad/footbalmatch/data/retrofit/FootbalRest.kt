package com.example.ahmad.footbalmatch.data.retrofit

import com.example.ahmad.footbalmatch.data.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballRest {

    @GET("eventPast.php")
    fun getLastmatch(@Query("id") id: String): Observable<Events>

    @GET("eventNext.php")
    fun getNextmatch(@Query("id") id: String): Observable<Events>

    @GET("lookupTeam.php")
    fun getTeam(@Query("id") id: String?): Observable<Teams>

    @GET("lookupEvent.php")
    fun getEventById(@Query("id") id: String): Observable<Events>

    @GET("searchEvent.php")
    fun searchEvent(@Query("e") query: String?): Observable<SearchedMatches>

    @GET("searchTeam.php")
    fun searchTeams(@Query("t") id: String): Observable<Teams>

    @GET("searchAllTeam.php")
    fun getAllTeam(@Query("l") id: String): Observable<Teams>

    @GET("getAllPlayer.php")
    fun getAllPlayers(@Query("id") id: String?): Observable<FootballPlayer>

    @GET("getPlayerDetail.php")
    fun getPlayerDetail(@Query("id") id: String?): Observable<PlayerDetail>

    @GET("getFavNews.php")
    fun getNews(@Query("q") id: String?): Observable<ArticleNews>
}