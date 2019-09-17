package com.example.quizbeta.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quizbeta.data.db.entities.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false

)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun getUserDao() : UserDao

    companion object
    {
        // It is immediately visible to all thread
        @Volatile
        private var instance : AppDatabase?=null

        /*
        This is use to prevent creation of multiple
        instance of the database
         */

        private val LOCK = Any()


        /*
           This invoke function will first take the context as it's parameter
           Then it will check if the instance of the database it not NULL
           IF the instance is not NULL , it will return the instance
           IF the instance is NULL , it will go inside the synchronized block **
           Inside the block , again it will check IF the instance is NULL
           it will call the function buildDatabase()
        */
        operator fun invoke(context: Context) = instance?: synchronized(LOCK)
        {
            instance?:buildDatabase(context).also {
                instance = it
            }
        }


        /*
          This function build the database
          The context.applicationContext is to determine that even we are getting
          it from a fragment it will still get from the applicationContext
       */
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}