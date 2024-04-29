package com.example.multifunctionalvideoplayer


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayerExo(
    videoUrl: String
) {
    val context = LocalContext.current

    // ExoPlayer nesnesi oluşturulur
    val player = ExoPlayer.Builder(context).build().apply {
        // Video Oynatıcı için medya öğesini ayarlar
        setMediaItem(MediaItem.fromUri(videoUrl))
    }

    // Video Oynatıcı nesnesi oluşturuyor
    val playerView = PlayerView(context)

    // Play/Pause durumlarını kaydeder
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }
    playerView.player = player

    // Oynatıcı değiştiğinde tetiklenir
    LaunchedEffect(player) {

        // Oynatıcını playWhenReady-e göre hareket etmesini söyler
        player.prepare()
        player.playWhenReady = playWhenReady

    }

    AndroidView(

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),

        factory = {
            playerView
        }
    )
}