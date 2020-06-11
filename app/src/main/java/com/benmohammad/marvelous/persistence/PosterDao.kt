package com.benmohammad.marvelous.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.benmohammad.marvelous.model.Poster

@Dao
interface PosterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosterList(posters: List<Poster>)

    @Query("SELECT * FROM Poster Where id = :id_")
    fun getPoster(id_: Long): Poster

    @Query("SELECT * FROM Poster")
    fun getPosterList(): List<Poster>
}