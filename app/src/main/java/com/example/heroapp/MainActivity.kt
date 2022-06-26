package com.example.heroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.heroapp.apollo.apolloClient


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(ReposQuery("android", 50)).execute()

            Log.d("Repos", "Success ${response.data}")
        }

    }
}

