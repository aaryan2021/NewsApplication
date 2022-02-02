package com.example.inshortsclone.data.model.latestModel

data class LatestNewsResponse(
    val nextPage: Int,
    val results: List<Result>,
    val status: String,
    val totalResults: Int
)