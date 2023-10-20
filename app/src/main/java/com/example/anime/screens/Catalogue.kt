package com.example.anime.screens

import android.media.Rating
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.anime.R
import com.example.anime.data.Hero
import com.example.anime.models.Data
import com.example.anime.retrofit.AnimeApi
import com.example.anime.retrofit.ApiService
import com.example.anime.ui.theme.AnimeTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogueSearch(
    modifier: Modifier = Modifier,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onSearchButtonClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp), // Добавьте горизонтальные отступы, если нужно
        horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = searchText,
            onValueChange = {
                onSearchTextChange(it)
            },
            placeholder = { Text(text = "Search...") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogueScreen(){
    var searchText by remember { mutableStateOf("") }
    var animeList by remember { mutableStateOf<List<Data>>(emptyList()) }

    // Получаем данные из API
    LaunchedEffect(searchText) {
        val api = ApiService.animeApi
        val response = api.getAnimeList(searchText)
        if (response.isSuccessful) {
            animeList = response.body()?.data ?: emptyList()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CatalogueSearch(
            Modifier.background(Color.Transparent),
            searchText = searchText,
            onSearchTextChange = { searchText = it },
            onSearchButtonClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp)) // Пространство между поиском и элементами списка
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            content = {
                itemsIndexed(animeList) { index, data ->
                    CatalogueItem(data = data)
                }
            }
        )

    }
}





@Composable
fun CatalogueItem(
    data: Data,
    modifier: Modifier = Modifier
        .padding(all = 10.dp)
        .height(350.dp)
){
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier.clickable { expanded = !expanded } // Handle click on the Card
    ) {
        Column(modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                AnimeIndex(data.title)
            }
            Spacer(modifier = Modifier.width(6.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                AnimeData(data.episodes, data.rating, data.year)
            }
            Spacer(modifier = Modifier.width(6.dp))
            AnimeIcon(data.images.jpg.image_url)



            if (expanded) {

            }
        }
    }
}

@Composable
fun AnimeIcon(
    imageUrl: String,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.screenshot_1)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(426.dp, 240.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun AnimeIndex(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@Composable
fun AnimeData(
    @StringRes episodes: Int,
    rating: String,
    @StringRes year: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Episodes: $episodes",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.width(16.dp))
        if (year!=0) {
            Text(
                text = "Year: $year",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Preview
@Composable
fun AnimeData() {
    AnimeTheme(darkTheme = false) {
        CatalogueScreen()
    }
}

@Preview
@Composable
fun CatalogueDarkThemePreview() {
    AnimeTheme(darkTheme = true) {
        CatalogueScreen()
    }
}