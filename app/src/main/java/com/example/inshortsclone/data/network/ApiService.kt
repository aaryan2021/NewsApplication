package com.example.inshortsclone.data.network
import com.example.inshortsclone.data.model.latestModel.LatestNewsResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET
    suspend fun GetLatestNews(@Url url:String): Response<LatestNewsResponse>

}