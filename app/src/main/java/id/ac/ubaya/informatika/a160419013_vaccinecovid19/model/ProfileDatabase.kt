package id.ac.ubaya.informatika.a160419013_vaccinecovid19.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Profile::class), version = 1)
abstract class ProfileDatabase:RoomDatabase(){
    abstract fun profileDao():ProfileDao

    companion object{
        @Volatile private var instance:ProfileDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ProfileDatabase::class.java,
            "profile"
        )
            .build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }
}