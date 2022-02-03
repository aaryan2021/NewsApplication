package com.example.inshortsclone.data.model.latestModel

data class LatestNewsResponse(
    val nextPage: Int,
    val results: List<News>,
    val status: String,
    val totalResults: Int
)