package com.example.tweetapp.api

import com.example.tweetapp.models.TweetsListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetApi {
    @GET("/v3/b/675d20feacd3cb34a8b95d31?meta=false")
    suspend fun getTweet(@Header("X-JSON-Path") category: String): Response<List<TweetsListItem>>

    @GET("/v3/b/675d20feacd3cb34a8b95d31?meta=false")
    @Headers("x-json-path:tweets..category")
    suspend fun getCategory(): Response<List<String>>
}