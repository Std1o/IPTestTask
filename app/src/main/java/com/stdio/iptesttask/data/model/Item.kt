package com.stdio.iptesttask.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val name: String,
    val time: Long,
    val tags: String,
    val amount: Int
) : Parcelable {
}