package com.example.composedemoapp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemoapp.data.QuotesData
import com.example.composedemoapp.repository.DemoAppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DemoDataViewModel @Inject constructor(
    private val demoAppRepo: DemoAppRepo,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val _quotes: StateFlow<List<QuotesData>>
        get() = demoAppRepo.getQuotes

    init {
        viewModelScope.launch {
            val filter = savedStateHandle.get<String>("category") ?: "motivational"
            demoAppRepo.getQuotes(filter)
        }
    }

}