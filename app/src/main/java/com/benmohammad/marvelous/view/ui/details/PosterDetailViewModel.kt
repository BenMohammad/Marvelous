package com.benmohammad.marvelous.view.ui.details

import com.benmohammad.marvelous.base.LiveCoroutinesViewModel
import com.benmohammad.marvelous.repository.DetailRepository

class PosterDetailViewModel(
    private val repository: DetailRepository
): LiveCoroutinesViewModel() {

    fun getPoster(id: Long) = repository.getPosterById(id)
}