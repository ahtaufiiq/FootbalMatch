package com.example.ahmad.footbalmatch.view.main.news

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ahmad.footbalmatch.R
import com.example.ahmad.footbalmatch.data.response.News
import com.example.ahmad.footbalmatch.view.main.news.detailNews.DetailNewsActivity
import kotlinx.android.synthetic.main.card_news.view.*

class NewsAdapter(var items: List<News>, val context: Context) : RecyclerView.Adapter< NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_news, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.apply {
            titleNews.text=item.title
            Glide.with(context)
                    .load(item.urlToImage)
                    .into(imageNews)
            itemView.setOnClickListener {
                val intent= Intent(context,DetailNewsActivity::class.java)

                val pair1 = Pair.create<View, String>(holder.itemView.findViewById(R.id.img_news), "image")
                val pair2 = Pair.create<View, String>(holder.itemView.findViewById(R.id.img_news), "title")
                val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, pair1, pair2)

                intent.putExtra("news",item)
                context.startActivity(intent, optionsCompat.toBundle())
            }

        }


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleNews=itemView.tv_title
        val imageNews=itemView.img_news


    }


}