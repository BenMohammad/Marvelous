package com.benmohammad.marvelous.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.benmohammad.marvelous.model.Poster

@Database(entities = [Poster::class], version = 1, exportSchema = true)
@TypeConverters(value = [IntegerListConverter::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun posterDao(): PosterDao
}