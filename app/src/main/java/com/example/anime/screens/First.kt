package com.example.anime.screens

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.anime.R
import com.example.anime.data.Hero
import com.example.anime.data.heroes
import com.example.anime.ui.theme.AnimeTheme

@Composable
fun AnimeTopAppBar(modifier: Modifier = Modifier){

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(){
    Scaffold(
        topBar = {
            AnimeTopAppBar()
        }
    ) {it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                HeroItem(
                    hero = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
            }
        }
    }
}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
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
                HeroIndex(hero.heroId, hero.name)
            }
            HeroIcon(hero.imageUrl)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Spacer(modifier = Modifier.weight(1f))
            }
            if (expanded) {
                HeroInformation( hero.age, hero.hobbies
                    , modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}


@Composable
fun HeroIndex(
    heroIndex: Int,
    @StringRes heroName: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.hero, heroIndex) +": "+ stringResource(heroName),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroIcon(
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
fun HeroInformation(
    heroAge: Int,
    @StringRes heroHobby: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text ="Age: " + stringResource(R.string.years_old, heroAge),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text ="Hobby: " + stringResource(heroHobby),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview
@Composable
fun HeroPreview() {
    AnimeTheme(darkTheme = false) {
        FirstScreen()
    }
}

@Preview
@Composable
fun HeroDarkThemePreview() {
    AnimeTheme(darkTheme = true) {
        FirstScreen()
    }
}