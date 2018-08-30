package com.mohsenmb.arch.domain

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readParcelable(RepoOwner::class.java.classLoader),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readLong(),
            parcel.readLong()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeParcelable(owner, flags)
        parcel.writeByte(if (isPrivate) 1 else 0)
        parcel.writeString(repoUrl)
        parcel.writeString(repoDescription)
        parcel.writeString(createdAt)
        parcel.writeString(updatedAt)
        parcel.writeString(language)
        parcel.writeLong(forks)
        parcel.writeLong(stars)
        parcel.writeLong(openIssues)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Repo> {
        override fun createFromParcel(parcel: Parcel): Repo {
            return Repo(parcel)
        }

        override fun newArray(size: Int): Array<Repo?> {
            return arrayOfNulls(size)
        }
    }
}