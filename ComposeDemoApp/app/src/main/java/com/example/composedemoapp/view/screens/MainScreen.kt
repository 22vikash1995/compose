package com.example.composedemoapp.view.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composedemoapp.data.Constants
import com.example.composedemoapp.data.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Constants.home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = Constants.home,
            ) { HomeScreen(navController) }

            composable(
                route = Constants.notification + "/{name}",
                arguments = listOf(navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "No Value"
                })
            ) { backEntryStack ->
                val name = backEntryStack.arguments?.getString("name") ?: "No name"
                Notification(name)
            }


            composable(Constants.settings) { Settings() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavItem(Constants.home, Icons.Default.Home, 0, Constants.home),
        NavItem(
            Constants.notification,
            Icons.Default.Notifications,
            5,
            Constants.notification + "/No value"
        ),
        NavItem(Constants.settings, Icons.Default.Settings, 0, Constants.settings)
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    val route =
                        if (item.route == Constants.notification) "${item.route}/default" else item.route
                    navController.navigate(route) {
                        launchSingleTop = true//to prevent duplicate entry
                    }
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount > 0) {
                                Badge { Text(text = item.badgeCount.toString()) }
                            }
                        },
                        modifier = Modifier.padding(start = 20.dp)
                    ) {}

                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(text = item.label) }
            )
        }
    }
}
