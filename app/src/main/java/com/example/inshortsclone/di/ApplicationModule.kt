package com.example.inshortsclone.di

import android.content.Context
import com.example.currencyexchanage.utils.HelperMethods
import com.example.inshortsclone.BuildConfig
import com.example.inshortsclone.data.localDatabase.AppdataBase
import com.example.inshortsclone.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideOkhttpClient(@ApplicationContext context: Context): OkHttpClient {
        val httpLoggingInterceptor= HttpLoggingInterceptor()
        httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).readTimeout(60,
            TimeUnit.SECONDS).callTimeout(60,TimeUnit.SECONDS) .build()

    }
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =Retrofit
        .Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun provideService(retrofit: Retrofit): ApiService =retrofit.create(ApiService::class.java)

    @Provides
    fun providelocalservice(@ApplicationContext context: Context):AppdataBase= AppdataBase.getDatabaseInstance(context)


    @Provides
    fun provideHelperMethods(@ApplicationContext context: Context):HelperMethods= HelperMethods(context)
}
