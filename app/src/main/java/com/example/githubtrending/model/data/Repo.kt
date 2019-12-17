package com.example.githubtrending.model.data


import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("incomplete_results")
    var incompleteResults: Boolean = false,
    @SerializedName("items")
    var items: List<Item> = listOf(),
    @SerializedName("total_count")
    var totalCount: Int = 0
)