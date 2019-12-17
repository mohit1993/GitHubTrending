package com.example.githubtrending.model.remote

import com.example.githubtrending.model.data.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("search/repositories?q=all&sort=stars&order=desc&per_page=30")
    fun getRepositories(@Query("page") page: Int): Call<Repo>

}