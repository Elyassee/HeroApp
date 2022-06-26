package com.example.heroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.http.HttpHeader
import java.util.*

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://api.github.com/graphql")
    .httpHeaders(listOf(HttpHeader("Authorization", "Bearer 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")))
    .build()

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

