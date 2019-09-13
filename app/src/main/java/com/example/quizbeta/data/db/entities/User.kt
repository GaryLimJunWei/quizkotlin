package com.example.quizbeta.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class User(
    var id : Int? = null,
    var empid : Int? = null,
    var name : String? = null,
    var current_password : String? = null,
    var new_password : String? = null,
    var confirm_password : String? = null
)
{
    @PrimaryKey(autoGenerate = false)
    var uid : Int = CURRENT_USER_ID
}
