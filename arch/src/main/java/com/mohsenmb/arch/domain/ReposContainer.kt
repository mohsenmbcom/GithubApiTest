package com.mohsenmb.arch.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ReposContainer(
        @Expose @SerializedName("total_count") val totalCount: Int,
        @Expose @SerializedName("items") val repos: List<Repo>
)