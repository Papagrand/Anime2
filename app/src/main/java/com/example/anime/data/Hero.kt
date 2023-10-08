package com.example.anime.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

import com.example.anime.R

data class Hero(
    val imageUrl: String,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int,
    val heroId: Int
)

val heroes = listOf(
    Hero("https://i.yapx.cc/QUYDz.jpg", R.string.hero_name_1, 17, R.string.hero_description_1, 1),
    Hero("https://i.pinimg.com/originals/ee/1e/a5/ee1ea5c446895c31e6a41c0dc819dafa.jpg", R.string.hero_name_2, 17, R.string.hero_description_2, 2),
    Hero("https://sportshub.cbsistatic.com/i/2022/06/06/23e708d7-ee9b-463e-8039-db9af1e7761e/my-hero-academia-jiro-vs-all-for-one-quirk-awakening-power-355-spoilers.jpg", R.string.hero_name_3, 14, R.string.hero_description_3, 3),
    Hero("https://static.wikia.nocookie.net/sk8theinfinity/images/b/ba/Reki%2C_excited_about_the_opportunity_to_talk_about_skateboarding.png/revision/latest/scale-to-width-down/1920?cb=20210317233106", R.string.hero_name_4, 17, R.string.hero_description_4, 4),
    Hero("https://api.duniagames.co.id/api/content/upload/file/17785865151648813549.jpg", R.string.hero_name_5, 16, R.string.hero_description_5, 5),
    Hero("https://static.wikia.nocookie.net/kurokonobasuke/images/e/e8/Tatsuya_Himuro_anime.png/revision/latest?cb=20150128045512&path-prefix=ru", R.string.hero_name_6, 18, R.string.hero_description_6, 6),
    Hero("https://inasianspaces.files.wordpress.com/2022/01/blue-period-ep-12-this-guy-yatora-lol.png?w=1200", R.string.hero_name_7, 18, R.string.hero_description_7, 7),
    Hero("https://staticg.sportskeeda.com/editor/2022/01/cbc36-16421825565301-1920.jpg", R.string.hero_name_8, 16, R.string.hero_description_8, 8)
)

