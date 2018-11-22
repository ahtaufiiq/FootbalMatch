package com.example.ahmad.footbalmatch.view.main.favorite

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ahmad.footbalmatch.R
import com.example.ahmad.footbalmatch.data.local.FavoriteTeam
import com.example.ahmad.footbalmatch.view.detail.detailTeam.DetailTeamActivity
import kotlinx.android.synthetic.main.card_team.view.*
import org.jetbrains.anko.startActivity

class FavoriteTeamAdapter(private val teamList: List<FavoriteTeam>, val context: Context?): RecyclerView.Adapter<FavoriteTeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(context).inflate(R.layout.card_team, parent, false))
    }

    override fun getItemCount() = teamList.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamList[position])
    }


    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(team: FavoriteTeam){
            itemView.tvTeam.text = team.teamName
            Glide.with(itemView.context)
                    .load(team.teamBadge)
                    .into(itemView.imgTeam)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailTeamActivity>("event" to team.idTeam)
            }

        }

    }
}