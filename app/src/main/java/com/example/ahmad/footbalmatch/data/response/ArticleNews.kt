package com.example.ahmad.footbalmatch.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleNews(
        @SerializedName("status") var status: String?,
        @SerializedName("totalResults") var totalResults: String,
        @SerializedName("articles") var articles: List<News>
) : Parcelable