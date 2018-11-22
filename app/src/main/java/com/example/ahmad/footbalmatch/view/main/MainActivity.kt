package com.example.ahmad.footbalmatch.view.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ahmad.footbalmatch.R
import com.example.ahmad.footbalmatch.R.id.*
import com.example.ahmad.footbalmatch.view.authentication.LoginActivity
import com.example.ahmad.footbalmatch.view.main.favorite.FavoriteFragment
import com.example.ahmad.footbalmatch.view.main.match.MatchesFragment
import com.example.ahmad.footbalmatch.view.main.news.NewsFragment
import com.example.ahmad.footbalmatch.view.main.team.TeamFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                navigation_next_match -> {
                    loadNextMatchFragment(savedInstanceState)
                    supportActionBar?.elevation=4F

                }
                navigation_favorite -> {
                    loadFavoritesFragment(savedInstanceState)
                    supportActionBar?.elevation=0F

                }
                navigation_last_match -> {
                    loadLastMatchFragment(savedInstanceState)
                    supportActionBar?.elevation=0F

                }
                navigation_news -> {
                    loadNewsFragment(savedInstanceState)
                    supportActionBar?.elevation=0F

                }

            }
            true
        }
        navigation.selectedItemId = R.id.navigation_last_match

    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamFragment(), TeamFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadLastMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, MatchesFragment(), MatchesFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoriteFragment(), FavoriteFragment::class.java.simpleName)
                    .commit()
        }
    }
    private fun loadNewsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, NewsFragment(), NewsFragment::class.java.simpleName)
                    .commit()
        }
    }

    override fun onStart() {
        if (FirebaseAuth.getInstance().currentUser == null) {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        super.onStart()
    }
}
