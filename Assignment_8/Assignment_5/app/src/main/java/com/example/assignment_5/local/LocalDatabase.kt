package com.example.assignment_5.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ArticleEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, LocalDatabase::class.java, "assignment.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}