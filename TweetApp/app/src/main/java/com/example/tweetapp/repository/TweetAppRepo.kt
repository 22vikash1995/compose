package com.example.tweetapp.repository

import com.example.tweetapp.api.TweetApi
import com.example.tweetapp.models.TweetsListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class TweetAppRepo @Inject constructor(private val tweetApi: TweetApi) {
    private val _category = MutableStateFlow<List<String>>(emptyList())
    val category: StateFlow<List<String>>
        get() = _category
    private val _tweets = MutableStateFlow<List<TweetsListItem>>(emptyList())
    val getTweets: StateFlow<List<TweetsListItem>>
        get() = _tweets

    suspend fun getCategory() {
        val response = tweetApi.getCategory()
        if (response.isSuccessful && response.body() != null) {
            _category.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweetApi.getTweet("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}