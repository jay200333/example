package com.example.ex.component


import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    onClicked: () -> Unit,
    icon: Painter,
    description: String? = null
) {
    IconButton(onClick = onClicked) {
        Icon(painter = icon, contentDescription = description)
    }
}
