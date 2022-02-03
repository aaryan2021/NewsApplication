package com.example.inshortsclone.data.localDatabase

import androidx.room.*
import com.example.inshortsclone.data.model.latestModel.News

@Dao
interface NewsDao {
    /*-----------INSERT NEWS ITEM IN TABLE------------*/
    @Insert
    fun insert(news: News)

    /*-----------UPDATE NEWS ITEM IN TABLE------------*/
    @Update
    fun  update(news: News)

    /*-----------DELETE NEWS ITEM IN TABLE------------*/
    @Delete
    fun delete(news: News)

    /*-----------GET ALL NEWS ITEM IN TABLE------------*/
    @Query("SELECT * FROM news")
    fun getAll(): List<News>?

}