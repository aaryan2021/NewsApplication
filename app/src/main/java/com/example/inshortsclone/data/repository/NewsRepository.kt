package com.example.inshortsclone.data.repository

import android.content.Context
import com.example.currencyexchanage.utils.HelperMethods
import com.example.inshortsclone.BuildConfig
import com.example.inshortsclone.data.localDatabase.AppdataBase
import com.example.inshortsclone.data.model.latestModel.LatestNewsResponse
import com.example.inshortsclone.data.network.ApiService
import com.example.inshortsclone.data.network.SafeApiRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/*-----------NEWS REPOSITORY DATASOURCE------------*/
class NewsRepository @Inject constructor(private val apiService: ApiService,private var appdataBase: AppdataBase,private var helperMethods: HelperMethods): SafeApiRequest() {
    suspend fun getLatestNews(): LatestNewsResponse {
        var url:String="1/news?apikey="+ BuildConfig.API_KEY
        if(helperMethods.checkConnection()){
            var response= apiRequest {
                apiService.GetLatestNews(url)
            }
            for(i in response.results){
                appdataBase.appdao().insert(i)
            }
            return response
        }
        else{
            var response=LatestNewsResponse(1, appdataBase.appdao().getAll()!!,"200",10)
            return response
        }

    }
}