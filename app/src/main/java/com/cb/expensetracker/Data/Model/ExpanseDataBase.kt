package com.cb.expensetracker.Data.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cb.expensetracker.Data.Dao.ExpanseDao

@Database(entities = [ExpanseEntity::class], version = 1)
abstract class ExpanseDataBase :RoomDatabase() {
    abstract fun ExpanseDao(): ExpanseDao


    companion object{
        const val DATABASE_NAME = "expansedatabase"

        @JvmStatic
        fun getDatabase(context: Context):ExpanseDataBase{
            return Room.databaseBuilder(
                context,
                ExpanseDataBase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}