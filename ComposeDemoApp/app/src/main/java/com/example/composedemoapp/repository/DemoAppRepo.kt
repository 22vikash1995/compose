package com.example.composedemoapp.repository

import com.example.composedemoapp.api.DemoAPi
import com.example.composedemoapp.data.QuotesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class DemoAppRepo @Inject constructor(private val demoAPi: DemoAPi) {

    private val _quotes = MutableStateFlow<List<QuotesData>>(emptyList())

    val getQuotes: StateFlow<List<QuotesData>>
        get() = _quotes

    suspend fun getQuotes(filter: String) {
        //getting the response
        val response = demoAPi.getQuotesList("tweets[?(@.category==\"$filter\")]")
        if (response.isSuccessful && response.body() != null) {
            _quotes.emit(response.body()!!)
        }
    }
}