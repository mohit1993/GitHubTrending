package com.example.githubtrending.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.githubtrending.R
import com.example.githubtrending.model.data.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detailed_item.*

class DetailActivity : AppCompatActivity() {
    var mItem : Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_item)

        mItem = intent.getParcelableExtra("item")

        if(mItem != null){
            supportActionBar?.title = mItem?.name
            Picasso.with(this).load(mItem?.owner?.avatarUrl).into(imageView)
            tittle.text = mItem?.name
            full_description.text = mItem?.description
            stars.text = mItem?.stargazersCount.toString()
            fork.text = mItem?.forksCount.toString()
            open_issue.text =  mItem?.openIssues.toString()

            link_github.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(mItem?.htmlUrl))
                startActivity(intent)
            }


            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}