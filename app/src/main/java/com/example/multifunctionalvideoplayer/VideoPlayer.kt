package com.example.multifunctionalvideoplayer


import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun VideoPlayer(
    videoUri: Uri
)
{
    // Android görünümleri tanımlamamıza yardımcı olur
    AndroidView(

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),

        // VideoView'i oluşturur
        factory = { context ->

            VideoView(context)
                .apply {

                    // VideoPlayer için Urini çağırır
                    setVideoURI(videoUri)

                    // VideoPlayer'ı başlatmak için obje çağırıyoruz
                    val myController = MediaController(context)
                    myController.setAnchorView(this)
                    setMediaController(myController)

                    // VideoPlayer'ı başlatmak için her hareketi dinler
                    setOnPreparedListener {
                        start()
                    }
                }
        }
    )
}