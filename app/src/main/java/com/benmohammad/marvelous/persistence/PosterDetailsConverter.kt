package com.benmohammad.marvelous.persistence

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.benmohammad.marvelous.model.PosterDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IntegerListConverter {

    @TypeConverter
    fun fromString(value: String): List<PosterDetails>? {

        val listType = object : TypeToken<List<PosterDetails>>() {}.type
        return Gson().fromJson<List<PosterDetails>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<PosterDetails>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}