package com.stdio.iptesttask.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stdio.iptesttask.data.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = true)
abstract class ProductsDB : RoomDatabase() {

    abstract fun productsDAO(): ProductDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductsDB? = null

        fun getDatabase(
            context: Context
        ): ProductsDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsDB::class.java,
                    "item"
                ).createFromAsset("database/data.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}