package com.example.qouteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.qouteapp.screens.QuotesDetails
import com.example.qouteapp.screens.QuotesListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //to fetch data on background thread
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.currentPage.value==Pages.LISTING){
        if (DataManager.isDataLoaded.value) {
            QuotesListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(1f)
            ) {
                Text(
                    text = "Loading...", fontFamily = FontFamily.Monospace,
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }else{
        DataManager.currentQuote?.let { QuotesDetails(quotes = it) }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}
