package com.example.anime

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object CatalogueBar: BottomBarScreen(
        route = "catalogue",
        title = "Каталог",
        icon = Icons.Default.List
    )
    object FirstBar: BottomBarScreen(
        route = "lazyColumn",
        title = "Персонажи",
        icon = Icons.Default.Face
    )
    object ProfileBar: BottomBarScreen(
        route = "profile",
        title = "Профиль",
        icon = Icons.Default.Person
    )
}
