package com.example.jetpack_tuto.room

import android.app.Application
import androidx.room.Room
import com.example.jetpack_tuto.room.AppDatabase


class MyApp: Application() {

    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {

        //SURCHARGE DE ON CREATE
        super.onCreate()
        db = Room.databaseBuilder(this, AppDatabase::class.java, "formation_db").build()
    }
}