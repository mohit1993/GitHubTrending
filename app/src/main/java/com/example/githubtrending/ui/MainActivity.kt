package com.example.githubtrending.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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
import android.util.Log
import android.widget.Toast
import com.example.githubtrending.data.model.Repo
import com.example.githubtrending.viewmodel.RepoViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var mAdapter : RepoItemAdapter
    private var mApiService : APIService? =null
    var mItemList : MutableList<Item> = arrayListOf()

    var mContext : Context? = null
//    companion object {
//        var page: Int = 1
//    }

    var mLayoutManager : LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this
        mApiService = ApiUtils.apiService

        mLayoutManager = LinearLayoutManager(mContext)
        recyclerView.layoutManager = mLayoutManager
        val model = ViewModelProviders.of(this)[RepoViewModel::class.java]
        if(model.getItem().value != null) {
            mAdapter = RepoItemAdapter(model.getItem().value as MutableList<Item>)
        } else {
            mAdapter = RepoItemAdapter(arrayListOf())
        }
        recyclerView.adapter = mAdapter
        supportActionBar?.title = "Git Hub Trending"
        //var startPos : Int = -1
        var isViewUpdated = true
        model.getItem().observe(this, Observer<List<Item>>{ items ->
            //mItemList.addAll(items!!)
            //startPos = mLayoutManager!!.findFirstVisibleItemPosition()
            //mAdapter  = RepoItemAdapter(items as MutableList<Item>)
            //recyclerView.adapter = mAdapter
            mAdapter.itemList = items as MutableList<Item>
            mAdapter.notifyDataSetChanged()
            //recyclerView.scrollToPosition(startPos)
            isViewUpdated = true
        })
        if(savedInstanceState != null)
            recyclerView.scrollToPosition(savedInstanceState.getInt("Position"))

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView!!.layoutManager.itemCount
                if (isViewUpdated && (totalItemCount == lastVisibleItemPosition + 1)) {
                    //page += 1
                    isViewUpdated = false
                    model.loadItem()
                }
            }
        })
    }

    private val lastVisibleItemPosition: Int
        get() = mLayoutManager!!.findLastVisibleItemPosition()

    override fun onStop() {
        //page = 1
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putInt("Position",mLayoutManager!!.findFirstVisibleItemPosition())
    }
}
