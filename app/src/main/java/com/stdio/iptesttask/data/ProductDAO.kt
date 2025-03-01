package com.stdio.iptesttask.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.stdio.iptesttask.domain.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDAO {
    @Query("SELECT * FROM Item ORDER BY name ASC")
    fun getAlphabetizedContacts(): Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Item)

    @Update
    suspend fun update(contact: Item)

    @Delete
    suspend fun delete(contact: Item)

    @Query("DELETE FROM Item")
    suspend fun deleteAll()
}