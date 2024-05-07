package com.example.multifunctionalvideoplayer

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun StartVideoPlayer(link: String) {
    VideoPlayerExo(videoUrl = link)
}