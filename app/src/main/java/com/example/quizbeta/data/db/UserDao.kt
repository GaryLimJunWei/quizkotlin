package com.example.quizbeta.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizbeta.data.db.entities.CURRENT_USER_ID
import com.example.quizbeta.data.db.entities.User

@Dao
interface UserDao
{
    /*
           This function handle the upload and insert
           for the user.
           The onConflict handle if there is 2 user logged
           in at the same time and replace the 2nd one
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User) : Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getuser() : LiveData<User>
}