package com.example.ex.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ex.R

@Composable
fun DetailGroupItem(profileImg: String?, name: String, removeButtonClick: () -> Unit) {
    Row(modifier = Modifier.padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically){
        CircleImg(imgUrl = profileImg, modifier = Modifier
            .clip(CircleShape)
            .size(54.dp))
        Text(modifier = Modifier.padding(start = 16.dp).weight(1f), text = name, style = MaterialTheme.typography.bodyMedium)
        Button(onClick = removeButtonClick) {
            Icon(painter = painterResource(R.drawable.baseline_remove_24), contentDescription = "remove button")
            Text(modifier = Modifier.padding(start = 8.dp), text = "제거", style = MaterialTheme.typography.labelMedium)
        }
    }
}
