package com.benmohammad.marvelous.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PosterDetails(
    val id: Long,
    val roomId: Long,
    val name: String,
    val plot: String,
    val poster: String
) : Parcelable