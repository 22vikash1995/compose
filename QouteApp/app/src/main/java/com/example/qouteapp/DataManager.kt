package com.example.qouteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.qouteapp.model.Quotes
import com.google.gson.Gson

object DataManager {
    val currentPage = mutableStateOf(Pages.LISTING)
    var data = emptyArray<Quotes>()
    var currentQuote: Quotes? = null
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quotes>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quotes: Quotes?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote=quotes
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}