package com.example.githubtrending.data.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubtrending.R
import com.example.githubtrending.ui.DetailActivity
import com.example.githubtrending.data.model.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_item.view.*

class RepoItemAdapter(items : MutableList<Item>) : RecyclerView.Adapter<RepoItemAdapter.ViewHolder>(){

    var itemList: MutableList<Item> = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var repo = itemList[position]
        holder.repo = repo
        Picasso.with(holder.itemView.context).load(repo.owner?.avatarUrl).into(holder.view.image)
        holder.view.tittle.text = repo.name
        holder.view.description.text = repo.fullName
        holder.view.watchers.text = " " + String.format("%,d", repo?.forksCount)
        holder.view.language.text = repo.language

    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view), View.OnClickListener{

        var view: View = view
        var repo: Item? = null
        init {
            view.setOnClickListener(this)
        }
        override fun onClick(view: View?) {
            val context = itemView.context
            val viewRepoIntent = Intent(context, DetailActivity::class.java)
            viewRepoIntent.putExtra("item", repo)
            context.startActivity(viewRepoIntent)
        }
    }
}