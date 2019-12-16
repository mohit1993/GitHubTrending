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
import com.example.githubtrending.ui.MainActivity.Companion.page
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoViewModel : ViewModel() {

    private val item: MutableLiveData<List<Item>> by lazy {
        MutableLiveData<List<Item>>().also {
            loadItem()
        }
    }

    fun getItem(): LiveData<List<Item>> {
        return item
    }

    fun loadItem() {
        ApiUtils.apiService?.getRepositories(page)?.enqueue(object : Callback<Repo> {
            override fun onFailure(call: Call<Repo>?, t: Throwable?) {
                //Toast.makeText(,"Something went wrong", Toast.LENGTH_LONG)
            }

            override fun onResponse(call: Call<Repo>?, response: Response<Repo>?) {
                if (response != null) {
                    if (response.isSuccessful){
                        var repo = response.body()
                        item.setValue(repo?.items!!)
                    }
                }
            }
        })
    }

}