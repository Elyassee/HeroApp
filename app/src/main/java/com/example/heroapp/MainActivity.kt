package com.example.heroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroapp.apollo.RepoAdapter
import com.example.heroapp.apollo.apolloClient


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(ReposQuery("android", 50)).execute()
            val adapter = RepoAdapter(response.data!!.topic!!.repositories)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter

        }

    }
}

