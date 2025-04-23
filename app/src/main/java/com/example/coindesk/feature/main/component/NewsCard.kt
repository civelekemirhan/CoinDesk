package com.example.coindesk.feature.main.component

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun NewsCard(new: NewsItem,onSaveButtonClick: (savedData: NewsItem) -> Unit ) {


    var newBody by remember{
        mutableStateOf("")
    }



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
        Row(modifier = Modifier.fillMaxHeight(0.8f).fillMaxWidth()) {
            Column(modifier=Modifier.fillMaxSize().padding(10.dp)) {
                Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f)) {
                    Text(new.title)
                }
                Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(1f)) {


                    if(new.body.length<200){
                        newBody = new.body
                    }else{
                        newBody=new.body.substring(0, 200)
                    }

                    AndroidView(factory = { context ->
                        TextView(context).apply {
                            text = HtmlCompat.fromHtml(newBody +" ...", HtmlCompat.FROM_HTML_MODE_LEGACY)

                        }
                    })
                }
            }
        }
        Row(modifier=Modifier.fillMaxHeight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(onClick = {
                //To Do
            }) {
                Text("Devamını Oku")
            }
            IconButton(onClick = {
                    onSaveButtonClick(new)
            }) {
                Icon(imageVector = Icons.Default.Star,"")
            }
        }
    }
}


