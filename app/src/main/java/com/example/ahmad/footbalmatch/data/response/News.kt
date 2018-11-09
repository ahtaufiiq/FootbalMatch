package com.example.ahmad.footbalmatch.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
        @SerializedName("author") var author: String?,
        @SerializedName("title") var title: String,
        @SerializedName("urlToImage") var urlToImage: String,
        @SerializedName("publishedAt") var publishedAt: String,
        @SerializedName("content") var content: String,
        @SerializedName("url") var url: String
) : Parcelable