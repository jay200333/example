package com.example.ex.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CircleImg(imgUrl: String?, modifier: Modifier = Modifier) {
    if (imgUrl != null) {
        AsyncImage(
            model =  ImageRequest.Builder(LocalContext.current)
                .data(imgUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }

    else {
        // 기본 이미지 또는 대체 UI 표시
        Box(
            modifier = modifier
                .background(Color.Gray)
        )
    }
}
