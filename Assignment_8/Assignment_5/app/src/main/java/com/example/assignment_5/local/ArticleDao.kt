package com.example.assignment_5.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDao {
    @Query("SELECT * FROM ArticleEntity")
    fun getAll(): List<ArticleEntity>

    @Insert
    fun insert(article: ArticleEntity)

    @Delete
    fun delete(article: ArticleEntity)
}