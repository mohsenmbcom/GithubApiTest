package com.mohsenmb.arch.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repo(
        @Expose @SerializedName("id") val id: Long,
        @Expose @SerializedName("name") val name: String,
        @Expose @SerializedName("owner") val owner: RepoOwner,
        @Expose @SerializedName("private") val isPrivate: Boolean,
        @Expose @SerializedName("html_url") val repoUrl: String,
        @Expose @SerializedName("description") val repoDescription: String,
        @Expose @SerializedName("created_at") val createdAt: String,
        @Expose @SerializedName("updated_at") val updatedAt: String,
        @Expose @SerializedName("language") val language: String,
        @Expose @SerializedName("forks_count") val forks: Long,
        @Expose @SerializedName("stargazers_count") val stars: Long,
        @Expose @SerializedName("open_issues") val openIssues: Long
)