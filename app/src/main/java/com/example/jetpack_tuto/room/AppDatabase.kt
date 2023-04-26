package com.example.jetpack_tuto.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserRoom::class], version = 1, exportSchema = false )
abstract class AppDatabase: RoomDatabase() {

    abstract fun userRoomDao(): UserRoomDao
}