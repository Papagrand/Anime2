package com.example.anime.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.anime.ui.theme.AnimeTheme

@Composable
fun ProfileTopAppBar(modifier: Modifier = Modifier){

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(){
    Scaffold(
        topBar = {
            ProfileTopAppBar()
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding, modifier = Modifier.fillMaxSize()) {
            items(5) { index ->
                Text(text = "Profile $index", modifier = Modifier.padding(16.dp))
            }
        }
    }
}



@Preview
@Composable
fun ProfilePreview() {
    AnimeTheme(darkTheme = false) {
        ProfileScreen()
    }
}

@Preview
@Composable
fun ProfileDarkThemePreview() {
    AnimeTheme(darkTheme = true) {
        ProfileScreen()
    }
}