package com.example.tweetapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetapp.repository.TweetAppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetAppRepo):ViewModel(){
    val categories:StateFlow<List<String>>
            get() = repository.category
    init {
        viewModelScope.launch {
            repository.getCategory()
        }

    }
}