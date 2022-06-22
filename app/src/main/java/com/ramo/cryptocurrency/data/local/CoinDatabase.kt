package com.ramo.cryptocurrency.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ramo.cryptocurrency.data.local.dao.CoinDao
import com.ramo.cryptocurrency.domain.model.CoinItem

@Database(
    entities = [
        CoinItem::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CoinDatabase : RoomDatabase() {
    abstract val coinDao: CoinDao

    companion object {
        @Volatile
        private var INSTANCE: CoinDatabase? = null

        fun getDatabase(context: Context): CoinDatabase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                CoinDatabase::class.java,
                "coin_db"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}