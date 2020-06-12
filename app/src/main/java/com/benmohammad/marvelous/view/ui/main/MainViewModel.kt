package com.benmohammad.marvelous.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.benmohammad.marvelous.base.LiveCoroutinesViewModel
import com.benmohammad.marvelous.model.Poster
import com.benmohammad.marvelous.repository.MainRepository

class MainViewModel constructor(
    private val mainRepository: MainRepository
): LiveCoroutinesViewModel() {

    private var posterFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val posterListLiveData: LiveData<List<Poster>>

    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        this.posterListLiveData = this.posterFetchingLiveData.switchMap {
            launchOnViewModelScope {
                this.mainRepository.loadMarvelPosters{this.toastLiveData.postValue(it)}
            }
        }
    }

    fun fetchMarvelPosterList() = this.posterFetchingLiveData.postValue(true)
}