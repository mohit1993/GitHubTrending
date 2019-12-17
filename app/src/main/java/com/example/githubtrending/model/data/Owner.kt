package com.example.githubtrending.model.data


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Owner() : Parcelable {
    @SerializedName("avatar_url")
    var avatarUrl: String? = null
    @SerializedName("events_url")
    var eventsUrl: String? = null
    @SerializedName("followers_url")
    var followersUrl: String? = null
    @SerializedName("following_url")
    var followingUrl: String? = null
    @SerializedName("gists_url")
    var gistsUrl: String? = null
    @SerializedName("gravatar_id")
    var gravatarId: String? = null
    @SerializedName("html_url")
    var htmlUrl: String? = null
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("login")
    var login: String? = null
    @SerializedName("node_id")
    var nodeId: String? = null
    @SerializedName("organizations_url")
    var organizationsUrl: String? = null
    @SerializedName("received_events_url")
    var receivedEventsUrl: String? = null
    @SerializedName("repos_url")
    var reposUrl: String? = null
    @SerializedName("site_admin")
    var siteAdmin: Boolean = false
    @SerializedName("starred_url")
    var starredUrl: String? = null
    @SerializedName("subscriptions_url")
    var subscriptionsUrl: String? = null
    @SerializedName("type")
    var type: String? = null
    @SerializedName("url")
    var url: String? = null

    constructor(parcel: Parcel) : this() {
        avatarUrl = parcel.readString()
        eventsUrl = parcel.readString()
        followersUrl = parcel.readString()
        followingUrl = parcel.readString()
        gistsUrl = parcel.readString()
        gravatarId = parcel.readString()
        htmlUrl = parcel.readString()
        id = parcel.readInt()
        login = parcel.readString()
        nodeId = parcel.readString()
        organizationsUrl = parcel.readString()
        receivedEventsUrl = parcel.readString()
        reposUrl = parcel.readString()
        siteAdmin = parcel.readByte() != 0.toByte()
        starredUrl = parcel.readString()
        subscriptionsUrl = parcel.readString()
        type = parcel.readString()
        url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatarUrl)
        parcel.writeString(eventsUrl)
        parcel.writeString(followersUrl)
        parcel.writeString(followingUrl)
        parcel.writeString(gistsUrl)
        parcel.writeString(gravatarId)
        parcel.writeString(htmlUrl)
        parcel.writeInt(id)
        parcel.writeString(login)
        parcel.writeString(nodeId)
        parcel.writeString(organizationsUrl)
        parcel.writeString(receivedEventsUrl)
        parcel.writeString(reposUrl)
        parcel.writeByte(if (siteAdmin) 1 else 0)
        parcel.writeString(starredUrl)
        parcel.writeString(subscriptionsUrl)
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Owner> {
        override fun createFromParcel(parcel: Parcel): Owner {
            return Owner(parcel)
        }

        override fun newArray(size: Int): Array<Owner?> {
            return arrayOfNulls(size)
        }
    }
}