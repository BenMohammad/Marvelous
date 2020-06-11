package com.benmohammad.marvelous.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benmohammad.marvelous.base.LiveCoroutinesViewModel
import com.benmohammad.marvelous.repository.MainRepository

class MainViewModel constructor(
    private val mainRepository: MainRepository
): LiveCoroutinesViewModel() {

    private var posterFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()

}