package com.example.quizbeta.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_TEST_ID = 0

@Entity
data class Test(
    var id : Int? = null,
    var testName : String? = null,
    var NumberOfQuestions : Int? = null,
    var TimeLimit : Int? = null,
    var attempts : Int? = null,
    var results : String? = null
)
{
    @PrimaryKey(autoGenerate = false)
    var uid : Int = CURRENT_TEST_ID
}
