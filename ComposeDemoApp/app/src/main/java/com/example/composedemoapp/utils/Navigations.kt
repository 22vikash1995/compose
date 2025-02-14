/*
package com.example.composedemoapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemoapp.data.Constants
import com.example.composedemoapp.view.screens.HomeScreen
import com.example.composedemoapp.view.screens.Notification
import com.example.composedemoapp.view.screens.Settings

@Composable
fun NavigateScreen(modifier: Modifier, routes: String, selectedIndex: Int){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Constants.home, builder = {
        when(routes){
            Constants.home->{navController.navigate(Constants.home)}
            Constants.notification->{navController.navigate(Constants.notification)}
            Constants.settings->{navController.navigate(Constants.settings)}
        }

        */
/*composable(routes){
            Notification(modifier = modifier)
        }
        composable(routes){
            Settings(modifier = modifier)
        }*//*

    })
}*/
