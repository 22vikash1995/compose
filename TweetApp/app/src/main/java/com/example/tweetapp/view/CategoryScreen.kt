package com.example.tweetapp.view

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetapp.R
import com.example.tweetapp.viewmodel.CategoryViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CategoryScreen(onClick:(category:String)->Unit) {
    //viewModel() creates the object of the CategoryViewModel and assign to categoryViewModel object
    /*val categoryViewModel:CategoryViewModel= viewModel()*/
    val categoryViewModel:CategoryViewModel= hiltViewModel()
    // to manage state
    val categories:State<List<String>> = categoryViewModel.categories.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
         items(categories.value.distinct()){
            CategoryItem(itemTitle = it,onClick)
         }
    }
}


@Composable
fun CategoryItem(itemTitle: String, onClick:(category:String)->Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clickable{onClick(itemTitle)}
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(painterResource(id = R.drawable.bg_image), contentScale = ContentScale.Crop)
            .border(1.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter

    ) {
        Text(
            text = itemTitle,
            modifier = Modifier
                .padding(0.dp, 20.dp),
            fontFamily = FontFamily.Monospace,
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 18.sp

        )
    }
}
