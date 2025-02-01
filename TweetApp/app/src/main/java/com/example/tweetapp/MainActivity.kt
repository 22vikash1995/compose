package com.example.tweetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetapp.ui.theme.TweetAppTheme
import com.example.tweetapp.view.CategoryScreen
import com.example.tweetapp.view.DetailScreen

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    /*@Inject
    lateinit var tweetApi:TweetApi*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*GlobalScope.launch {
           var response=tweetApi.getCategory()
            val result=response.body()
            val distinct_result=result?.distinct()
            Log.d("Api_Response",distinct_result.toString())
        }*/
        setContent {
            TweetAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "category"){
        composable(route="category") {
            CategoryScreen(onClick = {
                navController.navigate("detail/${it}")
            })
        }
         composable(route = "detail/{category}", arguments = listOf(
             navArgument("category"){
                 type= NavType.StringType
             }
         )){
             DetailScreen()
         }

    }
}
