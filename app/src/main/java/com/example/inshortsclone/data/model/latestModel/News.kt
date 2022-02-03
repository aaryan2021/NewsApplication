package com.example.inshortsclone.data.model.latestModel

import androidx.room.Entity
import androidx.room.PrimaryKey

/*-----------CREATED NEWS TABLE HERE ------------*/
@Entity(tableName = "news")
data class News(
    @PrimaryKey
    val title: String,
    val description: String?,
    val image_url: String?,
    val link: String?,
    val pubDate: String?,
    val source_id: String?,
    val video_url: String?
)