package com.example.tweetapp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetapp.models.TweetsListItem
import com.example.tweetapp.repository.TweetAppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
 class TweetsDetailsViewModel @Inject constructor(private val repository:TweetAppRepo
 ,private val savedStateHandle: SavedStateHandle):ViewModel() {
    val _tweets:StateFlow<List<TweetsListItem>>
        get() = repository.getTweets

    init {
        viewModelScope.launch {
            val category=savedStateHandle.get<String>("category")?:"motivational"
            repository.getTweets(category)
        }
    }
}