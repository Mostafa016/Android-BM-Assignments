package com.example.assignment_5.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
    val imageURL: String?,
    val title: String?,
    val content: String?,
    @PrimaryKey val articleURL: String,
)