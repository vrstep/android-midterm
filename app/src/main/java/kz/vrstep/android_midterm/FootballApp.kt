package kz.vrstep.android_midterm

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.vrstep.android_midterm.composables.BottomNavigationBar
import kz.vrstep.android_midterm.composables.ImagesScreen
import kz.vrstep.android_midterm.composables.PlayersScreen

@Composable
fun FootballApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "images",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("images") { ImagesScreen() }
            composable("players") { PlayersScreen() }
        }
    }
}