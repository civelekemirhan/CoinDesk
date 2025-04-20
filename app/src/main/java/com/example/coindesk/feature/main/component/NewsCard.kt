package com.example.coindesk.feature.main.component

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.coindesk.feature.main.model.NewsItem
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun NewsCard(new: NewsItem) {


    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .wrapContentHeight()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),

        ) {

        Row(modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(new.imageurl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
            )
        }
        Row(modifier = Modifier.fillMaxHeight(1f).fillMaxWidth()) {
            Column(modifier=Modifier.fillMaxSize().padding(10.dp)) {
                Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f)) {
                    Text(new.title)
                }
                Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(1f)) {

                    val newBodyShort= new.body.substring(0, (new.body.length*0.5).toInt())

                    AndroidView(factory = { context ->
                        TextView(context).apply {
                            text = HtmlCompat.fromHtml(newBodyShort, HtmlCompat.FROM_HTML_MODE_LEGACY)
                        }
                    })
                }
            }
        }
    }
}


