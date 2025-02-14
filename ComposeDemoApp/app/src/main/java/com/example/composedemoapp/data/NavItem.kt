package com.example.composedemoapp.data

import android.widget.ImageView
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val badgeCount: Int,
    val route: String
)

