package com.example.anime

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.anime.ui.theme.AnimeTheme
import com.example.anime.ui.theme.md_theme_dark_background
import kotlinx.coroutines.launch

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AnimeTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            title = "Настройки",
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    },
                    drawerContent = {

                        DrawerBody(

                            items = listOf(
                                DrawerItem(
                                    id = "home",
                                    title = "Главная страница",
                                    contentDescription = "Go to home screen",
                                    icon = Icons.Default.Home
                                ),
                                DrawerItem(
                                    id = "help",
                                    title = "Помощь",
                                    contentDescription = "Get help",
                                    icon = Icons.Default.Info
                                ),
                                DrawerItem(
                                    id = "settings",
                                    title = "Настройки",
                                    contentDescription = "Go to settings screen",
                                    icon = Icons.Default.Settings
                                )
                            ),
                            onItemClick = {item ->
                                when (item.id) {
                                    "home" -> {
                                        println("Clicked on ${item.title}")
                                        startActivity(Intent(this@SettingsActivity, MainActivity::class.java))
                                    }
                                    "help" -> {
                                        println("Clicked on ${item.title}")
                                        startActivity(Intent(this@SettingsActivity, HelpActivity::class.java))
                                    }
                                    "settings" -> {
                                        // Обработка нажатия на Настройки
                                        println("Clicked on ${item.title}")
                                    }
                                }
                            }
                        )
                    }
                ) {it


                }
            }
        }

    }


}


