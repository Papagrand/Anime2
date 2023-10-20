package com.example.anime

import android.accounts.AuthenticatorDescription
import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerItem(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: ImageVector
)
