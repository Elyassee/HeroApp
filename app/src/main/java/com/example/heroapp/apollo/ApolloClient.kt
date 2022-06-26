package com.example.heroapp.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.http.HttpHeader

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://api.github.com/graphql")
    .httpHeaders(listOf(HttpHeader("Authorization", "Bearer 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")))
    .build()
