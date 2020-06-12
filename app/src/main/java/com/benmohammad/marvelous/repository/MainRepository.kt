package com.benmohammad.marvelous.repository

import androidx.lifecycle.MutableLiveData
import com.benmohammad.marvelous.model.Poster
import com.benmohammad.marvelous.network.MarvelClient
import com.benmohammad.marvelous.persistence.PosterDao
import com.skydoves.sandwich.*
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainRepository(
    private val marvelClient: MarvelClient,
    private val marvelDataSource: ResponseDataSource<List<Poster>>,
    private val posterDao: PosterDao
): Repository {

    override var isLoading = false

    init {
        Timber.d("Injection MainRepository")
    }

    suspend fun loadMarvelPosters(error: (String) -> Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<Poster>>()
        var posters = posterDao.getPosterList()
        if(posters.isEmpty()) {
            isLoading = true
            marvelClient.fetchMarvelPosters(marvelDataSource) {
                apiResponse -> isLoading = false
                apiResponse

                    .onSuccess {
                        data.whatIfNotNull {
                            posters = it
                            liveData.postValue(it)
                            posterDao.insertPosterList(it)
                        }
                    }
                    .onError { error(message())}
                    .onException { error(message())}
            }
        }
        liveData.apply { postValue(posters)}
    }
}