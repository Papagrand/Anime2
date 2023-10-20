package com.example.anime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.anime.ui.theme.md_theme_dark_primaryContainer
import com.example.anime.ui.theme.md_theme_light_onPrimary
import com.example.anime.ui.theme.md_theme_light_onPrimaryContainer
import com.example.anime.ui.theme.md_theme_light_primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold (
        bottomBar = { BottomBar(navController = navController) }
    ) {it
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.FirstBar,
        BottomBarScreen.CatalogueBar,
        BottomBarScreen.ProfileBar
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach{screen->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        modifier = Modifier.background(md_theme_light_onPrimaryContainer),
        label = {
            Text(text = screen.title, color = md_theme_light_onPrimary)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation ICON"
            )
        },
        selected = currentDestination?.hierarchy?.any(){
            it.route == screen.route
        }== true,
        unselectedContentColor = md_theme_light_onPrimary,
        selectedContentColor = md_theme_light_primary ,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}