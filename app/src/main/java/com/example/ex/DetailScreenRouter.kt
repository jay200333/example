package com.example.ex

import kotlinx.serialization.Serializable

@Serializable
sealed class DetailMainScreenRouter(val iconId: Int, val title: String)

@Serializable
data object DetailScreenRoute : DetailMainScreenRouter(R.drawable.baseline_dehaze_24, "카테고리")

@Serializable
data object GroupScreenRoute : DetailMainScreenRouter(R.drawable.baseline_group_24, "그룹원")
