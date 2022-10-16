package com.javadesl.news.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.javadesl.news.data.news.Item
import com.javadesl.news.ui.theme.NewsTheme
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    viewModel.getNews("tasnim")
    val response by viewModel.liveDataNews.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue),
        color = MaterialTheme.colors.error
    ) {
        showList(response?.result?.item)
    }
}

@Composable
fun showList(item: List<Item?>?) {
    LazyColumn(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 7.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item?.let {
            items(it) {
                newsItem(item = it)
            }
        }
    }
}

@Composable
fun newsItem(
    item: Item?,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(7))
    ) {
        Row(
            Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item?.enclosure?.attributes?.url)
                    .crossfade(true)
                    .build(),
                contentDescription = "icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(180.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(7))
                    .border(1.dp, Color.White, RoundedCornerShape(7))
            )

            Column(
                modifier = Modifier
                    .width(180.dp)
                    .height(180.dp)

            ) {
                Text(text = item?.title.toString())
            }


        }


    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //HomeScreen()
}