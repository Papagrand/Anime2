package com.example.anime

import android.widget.AdapterView.OnItemClickListener
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anime.ui.theme.md_theme_light_onPrimary
import com.example.anime.ui.theme.md_theme_light_onPrimaryContainer

@Composable
fun DrawerBody(
    items: List<DrawerItem>,
    modifier: Modifier = Modifier
        .background(md_theme_light_onPrimaryContainer).fillMaxSize(),
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (DrawerItem)->Unit
){
    LazyColumn(modifier){
        items(items){item ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(imageVector = item.icon, contentDescription = item.contentDescription, tint = md_theme_light_onPrimary)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle.copy(color = md_theme_light_onPrimary),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}