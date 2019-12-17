package com.example.githubtrending.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.widget.Toast
import com.example.githubtrending.data.model.Item
import com.example.githubtrending.data.model.Repo
import com.example.githubtrending.remote.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoViewModel : ViewModel() {
    private var page = 0
    private val itemList = ArrayList<Item>()
    private val item: MutableLiveData<List<Item>> by lazy {
        MutableLiveData<List<Item>>().also {
            loadItem()
        }
    }

    fun addItems(il : List<Item>) {
        itemList.addAll(il)
        item.value = itemList
    }

    fun getItem(): LiveData<List<Item>> {
        return item
    }

    fun loadItem() {
        page++
        ApiUtils.apiService?.getRepositories(page)?.enqueue(object : Callback<Repo> {
            override fun onFailure(call: Call<Repo>?, t: Throwable?) {
                Log.d("Mohit", "Failure")
            }

            override fun onResponse(call: Call<Repo>?, response: Response<Repo>?) {
                Log.d("Mohit", "Success")
                if (response != null) {
                    if (response.isSuccessful){
                        var repo = response.body()
                        //item.setValue(repo?.items!!)
                        addItems(repo?.items!!)
                    }
                }
            }
        })
    }

}