package com.example.githubtrending.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.widget.Toast
import com.example.githubtrending.model.data.Item
import com.example.githubtrending.model.data.Repo
import com.example.githubtrending.model.remote.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoViewModel(application: Application) : AndroidViewModel(application) {
    private var page = 1
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
        APIClient.apiService?.getRepositories(page)?.enqueue(object : Callback<Repo> {
            override fun onFailure(call: Call<Repo>?, t: Throwable?) {
                Toast.makeText(getApplication(),
                    "Network Failure! We will Try again when network available",Toast.LENGTH_LONG)
                    .show()

            }

            override fun onResponse(call: Call<Repo>?, response: Response<Repo>?) {
                if (response != null) {
                    if (response.isSuccessful){
                        page++
                        var repo = response.body()
                        addItems(repo?.items!!)
                    }
                }
            }
        })
    }

}