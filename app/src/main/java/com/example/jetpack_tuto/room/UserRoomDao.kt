package com.example.jetpack_tuto.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserRoomDao {

    @Query("SELECT * FROM user_room")
    suspend fun getAllUsers(): List<UserRoom>

    @Insert
    suspend fun insertUser(userRoom: UserRoom)
}
