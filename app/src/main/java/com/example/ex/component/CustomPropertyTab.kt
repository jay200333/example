package com.example.ex.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun PropertyTab(
    onClicked: () -> Unit,
    icon: Painter,
    description: String? = null,
    title: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        IconButton(onClicked = onClicked, icon = icon, description = description)
    }
}
