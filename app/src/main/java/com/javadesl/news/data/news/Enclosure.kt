package com.javadesl.news.data.news

import com.google.gson.annotations.SerializedName

data class Enclosure(
    @SerializedName("@attributes")
    val attributes: Attributes?
)