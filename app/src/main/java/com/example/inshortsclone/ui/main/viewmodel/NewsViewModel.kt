package com.example.inshortsclone.ui.main.viewmodel

import androidx.lifecycle.liveData
import com.example.currencyexchanage.utils.MyKeys
import com.example.inshortsclone.data.network.Resource
import com.example.inshortsclone.data.repository.NewsRepository
import com.example.inshortsclone.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository): BaseViewModel() {

   /*-------- CALLING LATEST NEWS REPOSITORY-------------*/
    fun getLatestNews() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getLatestNews()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}