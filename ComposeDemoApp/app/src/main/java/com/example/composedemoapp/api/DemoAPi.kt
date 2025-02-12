package com.example.composedemoapp.api

import com.example.composedemoapp.data.QuotesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface DemoAPi {
    @GET("/v3/b/675d20feacd3cb34a8b95d31?meta=false")
    suspend fun getQuotesList(@Header("X-JSON-path") quotes: String): Response<List<QuotesData>>
}