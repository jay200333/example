package com.example.ex

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ex.component.IconButton

@SuppressLint("RestrictedApi")
@Composable
fun MainScreen(mainNavController: NavController) {
    val bottomNavController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainDetailTopBar() },
        bottomBar = {
            val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val navList = listOf(
                DetailScreenRoute, GroupScreenRoute
            )
            BottomNavigation {
                navList.forEach { nav ->
                    val selected = currentDestination?.hasRoute(nav::class) ?: false
                    BottomNavigationItem(
                        selected = selected,
                        onClick = {
                            bottomNavController.navigate(nav) {
                                // 내비게이션 시작 지점까지 있는 모든 스택을 팝하는 부분
                                // 탭한 스크린만 남겨놓기 위한 설계
                                popUpTo(bottomNavController.graph.findStartDestination().id) {
                                    // 화면 성태 저장하는 부분
                                    saveState = true
                                }
                                // 같은 탭을 또 클릭했을 때 중복으로 스택에 쌓이지 않도록 하는 설정
                                launchSingleTop = true
                                // 같은 탭을 또 클릭했을 때 상태 유지를 위한 설정
                                restoreState = true
                            }
                        },
                        label = { Text(nav.title) },
                        icon = {
                            Icon(
                                painter = painterResource(id = nav.iconId),
                                tint = if (selected) Color.Black else Color.White,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        }
    )
    { innerPadding ->

        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            navController = bottomNavController,
            startDestination = DetailScreenRoute
        ) {
            composable<DetailScreenRoute> {
                DetailScreen()
            }
            composable<GroupScreenRoute> {
                GroupScreen()
            }
        }
    }
}


@Preview
@Composable
fun MainDetailTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        // 배경 이미지
        Image(
            painter = painterResource(R.drawable.waterfall),
            contentDescription = "배경 이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClicked = { /* 뒤로 가기 동작 */ },
                icon = painterResource(R.drawable.baseline_arrow_back_24),
                description = "뒤로 가기 아이콘 버튼"
            )

            IconButton(
                onClicked = { Log.d("detail", "설정 클릭됨") },
                icon = painterResource(R.drawable.baseline_settings_24),
                description = "설정 아이콘 버튼"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(text = "OS 스터디", style = MaterialTheme.typography.displayMedium, fontWeight = FontWeight.SemiBold)
            Text(text = "os 와압!!!", style = MaterialTheme.typography.bodySmall)
            Button(onClick = {}, shape = RoundedCornerShape(8.dp)) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(R.drawable.baseline_account_circle_24),
                    contentDescription = "그룹원 수 버튼"
                )
                Text(modifier = Modifier.padding(start = 8.dp), text = "10명 / 50명", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}
