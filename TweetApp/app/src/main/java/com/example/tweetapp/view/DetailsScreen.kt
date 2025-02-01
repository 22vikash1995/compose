package com.example.tweetapp.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetapp.viewmodel.TweetsDetailsViewModel

@Composable
fun DetailScreen() {
    /*val detailViewModel:TweetsDetailsViewModel= viewModel()*/
    val detailViewModel:TweetsDetailsViewModel= hiltViewModel()
    val tweets=detailViewModel._tweets.collectAsState()
    LazyColumn(content = {
        items(tweets.value){
            itemDetails(tweet = it.text)
        }
    }, modifier = Modifier.padding(10.dp))

}

@Composable
fun itemDetails(tweet:String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Text(
            text = tweet,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.titleMedium
        )

    }
}