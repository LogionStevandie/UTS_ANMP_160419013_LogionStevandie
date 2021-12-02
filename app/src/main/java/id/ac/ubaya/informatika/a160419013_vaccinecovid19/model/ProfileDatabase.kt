package id.ac.ubaya.informatika.a160419013_vaccinecovid19.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.util.MIGRATION_1_2

@Database(entities = arrayOf(Profile::class), version = 2)
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
            .addMigrations(MIGRATION_1_2)
            .build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }
}