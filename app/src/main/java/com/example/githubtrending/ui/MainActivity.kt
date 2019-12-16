package com.example.githubtrending.ui

import android.content.Context
import android.os.Bundle
import com.example.githubtrending.R
import com.example.githubtrending.data.model.Item
import com.example.githubtrending.data.adapter.RepoItemAdapter
import com.example.githubtrending.remote.APIService
import com.example.githubtrending.remote.ApiUtils
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.githubtrending.data.model.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var mAdapter : RepoItemAdapter
    private var mApiService : APIService? =null
    var mItemList : MutableList<Item> = arrayListOf()

    var mContext : Context? = null
    var page: Int = 1

    var mLayoutManager : LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this
        mApiService = ApiUtils.apiService

        mLayoutManager = LinearLayoutManager(mContext)
        recyclerView.layoutManager = mLayoutManager
        mAdapter  = RepoItemAdapter(mItemList)
        recyclerView.adapter = mAdapter
        supportActionBar?.title = "Git Hub Trending ..."

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView!!.layoutManager.itemCount
                if (totalItemCount == lastVisibleItemPosition + 1) {
                    page += 1
                    loadRepo()
                }
            }
        })

        loadRepo()
    }

    private val lastVisibleItemPosition: Int
        get() = mLayoutManager!!.findLastVisibleItemPosition()


    private fun loadRepo() {
        mApiService?.getRepositories(page)?.enqueue(object : Callback<Repo> {
            override fun onFailure(call: Call<Repo>?, t: Throwable?) {
                Toast.makeText(mContext,"Something went wrong",Toast.LENGTH_LONG)
            }

            override fun onResponse(call: Call<Repo>?, response: Response<Repo>?) {
                if (response != null) {
                    if (response.isSuccessful){
                        var repo = response.body()
                        mItemList.addAll(repo?.items!!)
                        mAdapter.itemList = mItemList
                        mAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
}
