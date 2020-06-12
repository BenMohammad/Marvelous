package com.benmohammad.marvelous.network

import com.benmohammad.marvelous.model.Poster
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ResponseDataSource

class MarvelClient(private val marvelService: MarvelService) {

    fun fetchMarvelPosters(
        dataSource: ResponseDataSource<List<Poster>>,
        onResult: (response: ApiResponse<List<Poster>>) -> Unit
    ) {
        dataSource
            .retry(3, 5000L)
            .combine(marvelService.fetchMarvelPosterList(), onResult)
            .request()
    }
}