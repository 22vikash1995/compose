package com.example.composedemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(heightDp = 500 )
@Composable
fun display(){
    LazyColumn(content = {
        items(getListData()){item ->
            BlogCategory(imageId = item.img, title =item.title , subtitle =item.subTitle )
        }
    })
    /*BlogCategory(imageId = R.drawable.user, title = "Vikash Kumar", subtitle ="Android Developer" )
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        CategoryListData().map {
            item->
            BlogCategory(imageId = item.img, title =item.title , subtitle =item.subTitle )
        }
    }*/

}
@Composable
fun BlogCategory(imageId:Int,title:String,subtitle:String) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(title, subtitle=subtitle, modifier = Modifier.weight(0.8f))
        }
    }
}

@Composable
 fun ItemDescription(title: String, subtitle: String,modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Thin,
        )
    }
}

data class Category(val img:Int,val title:String,val subTitle:String)

 private fun getListData(): MutableList<Category> {
   val list= mutableListOf<Category>()
     list.add(Category(R.drawable.user,"Vikash Kumar","Android Developer"))
     list.add(Category(R.drawable.user1,"Suman Shil","Web Developer"))
     list.add(Category(R.drawable.profile,"Viswas Khanna","Backend Developer"))
     list.add(Category(R.drawable.user,"Akram Kumar","FrontEnd Developer"))
     list.add(Category(R.drawable.user1,"Vishal Kumar","Android Developer"))
     list.add(Category(R.drawable.profile,"Vicky Kumar","Game Developer"))
     list.add(Category(R.drawable.user,"Vikky Kumar","Android Developer"))
     list.add(Category(R.drawable.user1,"Vivek Kumar","Android Developer"))
     list.add(Category(R.drawable.profile,"Vikram Kumar","Android Developer"))
     list.add(Category(R.drawable.user,"Virendra Kumar","Android Developer"))
     list.add(Category(R.drawable.user1,"Ashok Kumar","Android Developer"))
     list.add(Category(R.drawable.profile,"Vishnu Kumar","Web Developer"))
     list.add(Category(R.drawable.user,"Vikash Kumar","Devops Developer"))
     list.add(Category(R.drawable.user1,"Sachin Kumar","Android Developer"))

     list.add(Category(R.drawable.user,"Vikash Kumar","Android Developer"))
     list.add(Category(R.drawable.user1,"Suman Shil","Web Developer"))
     list.add(Category(R.drawable.profile,"Viswas Khanna","Backend Developer"))
     list.add(Category(R.drawable.user,"Akram Kumar","FrontEnd Developer"))
     list.add(Category(R.drawable.user1,"Vishal Kumar","Android Developer"))
     list.add(Category(R.drawable.profile,"Vicky Kumar","Game Developer"))
     list.add(Category(R.drawable.user,"Vikky Kumar","Android Developer"))
     list.add(Category(R.drawable.user1,"Vivek Kumar","Android Developer"))
     list.add(Category(R.drawable.profile,"Vikram Kumar","Android Developer"))
     list.add(Category(R.drawable.user,"Virendra Kumar","Android Developer"))
     list.add(Category(R.drawable.user1,"Ashok Kumar","Android Developer"))
     list.add(Category(R.drawable.profile,"Vishnu Kumar","Web Developer"))
     list.add(Category(R.drawable.user,"Vikash Kumar","Devops Developer"))
     list.add(Category(R.drawable.user1,"Sachin Kumar","Android Developer"))
    return list
}