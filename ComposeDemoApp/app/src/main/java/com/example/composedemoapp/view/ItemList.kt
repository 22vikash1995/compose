package com.example.composedemoapp.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composedemoapp.R
import com.example.composedemoapp.data.QuotesData
import com.example.composedemoapp.viewmodel.DemoDataViewModel

@Composable
fun itemList() {
    val demoDataViewModel: DemoDataViewModel = hiltViewModel()
    val data = demoDataViewModel._quotes.collectAsState()
    // use of lazyColumn to display the list of items
    LazyColumn(
        content = {
            items(data.value) {
                itemUi(it.text)
                Log.d("response_data",data.value.toString())
            }
        },
        modifier = Modifier.padding(10.dp)
    )

}

@Composable
fun itemUi(quotes: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.burger_hd),
                contentDescription = "image",
                modifier = Modifier
                    .size(width = 80.dp, height = 80.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
                    .align(Alignment.CenterVertically)
            )

            Text(
                text = quotes,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}