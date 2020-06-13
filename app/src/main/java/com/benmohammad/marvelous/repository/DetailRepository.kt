package com.benmohammad.marvelous.repository

import com.benmohammad.marvelous.persistence.PosterDao

class   DetailRepository constructor(
    private val posterDao: PosterDao
): Repository {

    override var isLoading = false

    fun getPosterById(id: Long) = posterDao.getPoster(id)
}