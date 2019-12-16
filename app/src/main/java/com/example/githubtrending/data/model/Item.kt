package com.example.githubtrending.data.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Item() : Parcelable {

    @SerializedName("archive_url")
    var archiveUrl: String? = null
    @SerializedName("archived")
    var archived: Boolean = false
    @SerializedName("assignees_url")
    var assigneesUrl: String? = null
    @SerializedName("blobs_url")
    var blobsUrl: String? = null
    @SerializedName("branches_url")
    var branchesUrl: String? = null
    @SerializedName("clone_url")
    var cloneUrl: String? = null
    @SerializedName("collaborators_url")
    var collaboratorsUrl: String? = null
    @SerializedName("comments_url")
    var commentsUrl: String? = null
    @SerializedName("commits_url")
    var commitsUrl: String? = null
    @SerializedName("compare_url")
    var compareUrl: String? = null
    @SerializedName("contents_url")
    var contentsUrl: String? = null
    @SerializedName("contributors_url")
    var contributorsUrl: String? = null
    @SerializedName("created_at")
    var createdAt: String? = null
    @SerializedName("default_branch")
    var defaultBranch: String? = null
    @SerializedName("deployments_url")
    var deploymentsUrl: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("disabled")
    var disabled: Boolean = false
    @SerializedName("downloads_url")
    var downloadsUrl: String? = null
    @SerializedName("events_url")
    var eventsUrl: String? = null
    @SerializedName("fork")
    var fork: Boolean = false
    @SerializedName("forks")
    var forks: Int = 0
    @SerializedName("forks_count")
    var forksCount: Int = 0
    @SerializedName("forks_url")
    var forksUrl: String? = null
    @SerializedName("full_name")
    var fullName: String? = null
    @SerializedName("git_commits_url")
    var gitCommitsUrl: String? = null
    @SerializedName("git_refs_url")
    var gitRefsUrl: String? = null
    @SerializedName("git_tags_url")
    var gitTagsUrl: String? = null
    @SerializedName("git_url")
    var gitUrl: String? = null
    @SerializedName("has_downloads")
    var hasDownloads: Boolean = false
    @SerializedName("has_issues")
    var hasIssues: Boolean = false
    @SerializedName("has_pages")
    var hasPages: Boolean = false
    @SerializedName("has_projects")
    var hasProjects: Boolean = false
    @SerializedName("has_wiki")
    var hasWiki: Boolean = false
    @SerializedName("homepage")
    var homepage: String? = null
    @SerializedName("hooks_url")
    var hooksUrl: String? = null
    @SerializedName("html_url")
    var htmlUrl: String? = null
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("issue_comment_url")
    var issueCommentUrl: String? = null
    @SerializedName("issue_events_url")
    var issueEventsUrl: String? = null
    @SerializedName("issues_url")
    var issuesUrl: String? = null
    @SerializedName("keys_url")
    var keysUrl: String? = null
    @SerializedName("labels_url")
    var labelsUrl: String? = null
    @SerializedName("language")
    var language: String? = null
    @SerializedName("languages_url")
    var languagesUrl: String? = null
    @SerializedName("license")
    var license: License? = null
    @SerializedName("merges_url")
    var mergesUrl: String? = null
    @SerializedName("milestones_url")
    var milestonesUrl: String? = null
    @SerializedName("mirror_url")
    var mirrorUrl: Any? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("node_id")
    var nodeId: String? = null
    @SerializedName("notifications_url")
    var notificationsUrl: String? = null
    @SerializedName("open_issues")
    var openIssues: Int = 0
    @SerializedName("open_issues_count")
    var openIssuesCount: Int = 0
    @SerializedName("owner")
    var owner: Owner? = null
    @SerializedName("private")
    var `private`: Boolean = false
    @SerializedName("pulls_url")
    var pullsUrl: String? = null
    @SerializedName("pushed_at")
    var pushedAt: String? = null
    @SerializedName("releases_url")
    var releasesUrl: String? = null
    @SerializedName("score")
    var score: Double = 0.0
    @SerializedName("size")
    var size: Int = 0
    @SerializedName("ssh_url")
    var sshUrl: String? = null
    @SerializedName("stargazers_count")
    var stargazersCount: Int = 0
    @SerializedName("stargazers_url")
    var stargazersUrl: String? = null
    @SerializedName("statuses_url")
    var statusesUrl: String? = null
    @SerializedName("subscribers_url")
    var subscribersUrl: String? = null
    @SerializedName("subscription_url")
    var subscriptionUrl: String? = null
    @SerializedName("svn_url")
    var svnUrl: String? = null
    @SerializedName("tags_url")
    var tagsUrl: String? = null
    @SerializedName("teams_url")
    var teamsUrl: String? = null
    @SerializedName("trees_url")
    var treesUrl: String? = null
    @SerializedName("updated_at")
    var updatedAt: String? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("watchers")
    var watchers: Int = 0
    @SerializedName("watchers_count")
    var watchersCount: Int = 0

    constructor(parcel: Parcel) : this() {
        archiveUrl = parcel.readString()
        archived = parcel.readByte() != 0.toByte()
        assigneesUrl = parcel.readString()
        blobsUrl = parcel.readString()
        branchesUrl = parcel.readString()
        cloneUrl = parcel.readString()
        collaboratorsUrl = parcel.readString()
        commentsUrl = parcel.readString()
        commitsUrl = parcel.readString()
        compareUrl = parcel.readString()
        contentsUrl = parcel.readString()
        contributorsUrl = parcel.readString()
        createdAt = parcel.readString()
        defaultBranch = parcel.readString()
        deploymentsUrl = parcel.readString()
        description = parcel.readString()
        disabled = parcel.readByte() != 0.toByte()
        downloadsUrl = parcel.readString()
        eventsUrl = parcel.readString()
        fork = parcel.readByte() != 0.toByte()
        forks = parcel.readInt()
        forksCount = parcel.readInt()
        forksUrl = parcel.readString()
        fullName = parcel.readString()
        gitCommitsUrl = parcel.readString()
        gitRefsUrl = parcel.readString()
        gitTagsUrl = parcel.readString()
        gitUrl = parcel.readString()
        hasDownloads = parcel.readByte() != 0.toByte()
        hasIssues = parcel.readByte() != 0.toByte()
        hasPages = parcel.readByte() != 0.toByte()
        hasProjects = parcel.readByte() != 0.toByte()
        hasWiki = parcel.readByte() != 0.toByte()
        homepage = parcel.readString()
        hooksUrl = parcel.readString()
        htmlUrl = parcel.readString()
        id = parcel.readInt()
        issueCommentUrl = parcel.readString()
        issueEventsUrl = parcel.readString()
        issuesUrl = parcel.readString()
        keysUrl = parcel.readString()
        labelsUrl = parcel.readString()
        language = parcel.readString()
        languagesUrl = parcel.readString()
        mergesUrl = parcel.readString()
        milestonesUrl = parcel.readString()
        name = parcel.readString()
        nodeId = parcel.readString()
        notificationsUrl = parcel.readString()
        openIssues = parcel.readInt()
        openIssuesCount = parcel.readInt()
        owner = parcel.readParcelable(Owner::class.java.classLoader)
        private = parcel.readByte() != 0.toByte()
        pullsUrl = parcel.readString()
        pushedAt = parcel.readString()
        releasesUrl = parcel.readString()
        score = parcel.readDouble()
        size = parcel.readInt()
        sshUrl = parcel.readString()
        stargazersCount = parcel.readInt()
        stargazersUrl = parcel.readString()
        statusesUrl = parcel.readString()
        subscribersUrl = parcel.readString()
        subscriptionUrl = parcel.readString()
        svnUrl = parcel.readString()
        tagsUrl = parcel.readString()
        teamsUrl = parcel.readString()
        treesUrl = parcel.readString()
        updatedAt = parcel.readString()
        url = parcel.readString()
        watchers = parcel.readInt()
        watchersCount = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(archiveUrl)
        parcel.writeByte(if (archived) 1 else 0)
        parcel.writeString(assigneesUrl)
        parcel.writeString(blobsUrl)
        parcel.writeString(branchesUrl)
        parcel.writeString(cloneUrl)
        parcel.writeString(collaboratorsUrl)
        parcel.writeString(commentsUrl)
        parcel.writeString(commitsUrl)
        parcel.writeString(compareUrl)
        parcel.writeString(contentsUrl)
        parcel.writeString(contributorsUrl)
        parcel.writeString(createdAt)
        parcel.writeString(defaultBranch)
        parcel.writeString(deploymentsUrl)
        parcel.writeString(description)
        parcel.writeByte(if (disabled) 1 else 0)
        parcel.writeString(downloadsUrl)
        parcel.writeString(eventsUrl)
        parcel.writeByte(if (fork) 1 else 0)
        parcel.writeInt(forks)
        parcel.writeInt(forksCount)
        parcel.writeString(forksUrl)
        parcel.writeString(fullName)
        parcel.writeString(gitCommitsUrl)
        parcel.writeString(gitRefsUrl)
        parcel.writeString(gitTagsUrl)
        parcel.writeString(gitUrl)
        parcel.writeByte(if (hasDownloads) 1 else 0)
        parcel.writeByte(if (hasIssues) 1 else 0)
        parcel.writeByte(if (hasPages) 1 else 0)
        parcel.writeByte(if (hasProjects) 1 else 0)
        parcel.writeByte(if (hasWiki) 1 else 0)
        parcel.writeString(homepage)
        parcel.writeString(hooksUrl)
        parcel.writeString(htmlUrl)
        parcel.writeInt(id)
        parcel.writeString(issueCommentUrl)
        parcel.writeString(issueEventsUrl)
        parcel.writeString(issuesUrl)
        parcel.writeString(keysUrl)
        parcel.writeString(labelsUrl)
        parcel.writeString(language)
        parcel.writeString(languagesUrl)
        parcel.writeString(mergesUrl)
        parcel.writeString(milestonesUrl)
        parcel.writeString(name)
        parcel.writeString(nodeId)
        parcel.writeString(notificationsUrl)
        parcel.writeInt(openIssues)
        parcel.writeInt(openIssuesCount)
        parcel.writeParcelable(owner,flags)
        parcel.writeByte(if (private) 1 else 0)
        parcel.writeString(pullsUrl)
        parcel.writeString(pushedAt)
        parcel.writeString(releasesUrl)
        parcel.writeDouble(score)
        parcel.writeInt(size)
        parcel.writeString(sshUrl)
        parcel.writeInt(stargazersCount)
        parcel.writeString(stargazersUrl)
        parcel.writeString(statusesUrl)
        parcel.writeString(subscribersUrl)
        parcel.writeString(subscriptionUrl)
        parcel.writeString(svnUrl)
        parcel.writeString(tagsUrl)
        parcel.writeString(teamsUrl)
        parcel.writeString(treesUrl)
        parcel.writeString(updatedAt)
        parcel.writeString(url)
        parcel.writeInt(watchers)
        parcel.writeInt(watchersCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}