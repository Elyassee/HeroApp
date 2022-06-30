package com.example.heroapp.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.http.HttpHeader

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://api.github.com/graphql")
    .httpHeaders(listOf(HttpHeader("Authorization", "Bearer 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")))
    .build()
