package com.example.ahmad.footbalmatch.data.repository

import com.example.ahmad.footbalmatch.data.response.*
import io.reactivex.Observable

interface FootballRepository {

    fun getLastMatch(id: String): Observable<Events>

    fun getNextMatch(id: String): Observable<Events>

    fun getTeams(id: String?): Observable<Teams>

    fun getEventById(id: String): Observable<Events>

    fun searchEvent(query: String?): Observable<SearchedMatches>

    fun searchTeams(id: String): Observable<Teams>

    fun getAllTeam(id: String): Observable<Teams>

    fun getAllPlayer(id: String): Observable<FootballPlayer>

    fun getPlayer(id: String): Observable<PlayerDetail>

    fun getNews(category: String): Observable<ArticleNews>
}