package com.mohsenmb.arch.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RepoOwner(
        @Expose @SerializedName("id") val id: Long,
        @Expose @SerializedName("login") val username: String,
        @Expose @SerializedName("avatar_url") val avatar: String
)