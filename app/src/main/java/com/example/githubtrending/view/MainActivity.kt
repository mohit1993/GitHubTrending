package com.example.githubtrending.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import com.example.githubtrending.R
import com.example.githubtrending.model.data.Item
import com.example.githubtrending.view.adapter.RepoItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.githubtrending.viewmodel.RepoViewModel


class MainActivity : AppCompatActivity() {

    lateinit var mAdapter : RepoItemAdapter
    var mLayoutManager : LinearLayoutManager? = null
    var mNetworkReceiver : BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager

        val model = ViewModelProviders.of(this)[RepoViewModel::class.java]
        if(model.getItem().value != null) {
            mAdapter = RepoItemAdapter(model.getItem().value as MutableList<Item>)
        } else {
            mAdapter = RepoItemAdapter(arrayListOf())
        }
        recyclerView.adapter = mAdapter

        var isViewUpdated = true

        //updating view
        model.getItem().observe(this, Observer<List<Item>>{ items ->
            mAdapter.itemList = items as MutableList<Item>
            progress_circular.visibility = View.GONE
            init_progress.visibility = View.GONE
            recyclerView.setPadding(0,0,0,0)
            mAdapter.notifyDataSetChanged()
            isViewUpdated = true
        })

        //requesting new bundle with Retrofit
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView!!.layoutManager.itemCount
                if (isViewUpdated && (totalItemCount == lastVisibleItemPosition + 1)) {
                    isViewUpdated = false
                    recyclerView.setPadding(0,0,0,200)
                    progress_circular.visibility = View.VISIBLE
                    model.loadItem()
                }
            }
        })


        //update if network connection restore
        mNetworkReceiver = object : BroadcastReceiver(){
            override fun onReceive(p0: Context, p1: Intent) {
                if(p1.extras != null) {
                    val ni = p1.extras.get(ConnectivityManager.EXTRA_NETWORK_INFO) as NetworkInfo
                    if(ni != null && ni.state == NetworkInfo.State.CONNECTED) {
                        model.loadItem()
                    }
                }
            }
        }

        //restore previous configuration position
        if(savedInstanceState != null)
            recyclerView.scrollToPosition(savedInstanceState.getInt("Position"))

        supportActionBar?.title = "Git Hub Trending"
    }

    private val lastVisibleItemPosition: Int
        get() = mLayoutManager!!.findLastVisibleItemPosition()

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putInt("Position",mLayoutManager!!.findFirstVisibleItemPosition())
    }

    override fun onResume() {
        super.onResume()

        val intentFilter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        this.registerReceiver(mNetworkReceiver,intentFilter)
     }

    override fun onPause() {
        super.onPause()
        this.unregisterReceiver(mNetworkReceiver)
    }
}
