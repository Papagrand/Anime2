package com.example.anime

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.anime.screens.CatalogueScreen
import com.example.anime.screens.FirstScreen
import com.example.anime.screens.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.FirstBar.route
    ){
        composable(route = BottomBarScreen.FirstBar.route){
            FirstScreen()
        }
        composable(route = BottomBarScreen.CatalogueBar.route){
            CatalogueScreen()
        }
        composable(route = BottomBarScreen.ProfileBar.route){
            ProfileScreen()
        }
    }
}