package com.javadesl.news.data.news


data class Result(
    val description: String?,
    val generator: String?,
    val item: List<Item?>?,
    val lastBuildDate: String?,
    val link: String?,
    val managingEditor: String?,
    val title: String?,
    val webMaster: String?
)