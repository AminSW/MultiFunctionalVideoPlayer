package com.example.multifunctionalvideoplayer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
@Composable
fun NavigationArgsSample(link: String) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "screen1"
    )
    {

        composable("screen1") {
            Screen1(link, onNavigateToScreen2 = {
                navController.navigate("screen2")
            })
        }

        composable("screen2") {
            Screen2(link)
        }
    }
}

@Composable
private fun Screen1(link: String, onNavigateToScreen2: (String) -> Unit) {
    Button(onClick = {
        onNavigateToScreen2(link)
    }) {
        Text(text = "Click me")
    }
}

@Composable
private fun Screen2(param: String = "") {
    StartVideoPlayer(link = param.trim())
}