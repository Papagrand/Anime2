package com.example.anime

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.anime.ui.theme.AnimeTheme
import com.example.anime.ui.theme.md_theme_light_onPrimary
import com.example.anime.ui.theme.md_theme_light_onPrimaryContainer

@Composable
fun AppBar(
    title: String,
    onNavigationIconClick: () -> Unit
){
    TopAppBar(
        title = {
            Text(text = title)
        },
        backgroundColor = md_theme_light_onPrimaryContainer,
        contentColor = md_theme_light_onPrimary,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "ToggleDrawer")
            }
        }
    )
}