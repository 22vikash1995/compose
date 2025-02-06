package com.example.composedemoapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ToolBarScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToolBarUI()
        }
    }
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun ToolBarUI() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "MyToolBar")
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Menu, contentDescription = "menu")
                        }
                    },
                    actions = {
                        switchView()
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.Notifications,
                                contentDescription = "notification"
                            )
                        }

                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White),

                )
            },

            bottomBar = {
                BottomAppBar(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Home, contentDescription = "home")
                        Icon(Icons.Default.Person, contentDescription = "person")
                        Icon(Icons.Default.Favorite, contentDescription = "favorite")
                        Icon(Icons.Default.ShoppingCart, contentDescription = "cart")
                        Icon(Icons.Default.Settings, contentDescription = "setting")
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Add, contentDescription = "add")
                    }
                }
            },
            floatingActionButtonPosition = FabPosition.End,
        ) {
            Text(text = "Hello World")
        }
        listItem()
    }


    @Composable
    fun switchView() {
        val isChecked = remember{ mutableStateOf(true) }
        Switch(
            checked =isChecked.value ,
            modifier = Modifier
                .padding(50.dp)
                .size(20.dp),
            onCheckedChange ={
                isChecked.value=it
            if (it){
                Toast.makeText(this,"ON",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"OFF",Toast.LENGTH_SHORT).show()
            }
        } )
    }

    @Composable
    fun listItem(){
         Text(text = "Hello")
    }
}