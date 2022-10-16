package com.javadesl.news.data.news


data class Item(
    val author: String?,
    val description: String?,
    val enclosure: Enclosure?,
    val link: String?,
    val pubDate: String?,
    val title: String?
)