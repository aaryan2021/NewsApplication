package com.example.inshortsclone.data.repository

import com.example.inshortsclone.BuildConfig
import com.example.inshortsclone.data.model.latestModel.LatestNewsResponse
import com.example.inshortsclone.data.network.ApiService
import com.example.inshortsclone.data.network.SafeApiRequest
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService): SafeApiRequest() {

    suspend fun getLatestNews(): LatestNewsResponse {
        var url:String="1/news?apikey="+ BuildConfig.API_KEY
        return apiRequest {
            apiService.GetLatestNews(url)
        }
    }
}