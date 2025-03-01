package com.stdio.iptesttask.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.stdio.iptesttask.domain.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Item::class], version = 1, exportSchema = true)
abstract class ProductsDB : RoomDatabase() {

    abstract fun productsDAO(): ProductDAO

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ProductsDB? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ProductsDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsDB::class.java,
                    "item"
                ).createFromAsset("database/data.db")
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}