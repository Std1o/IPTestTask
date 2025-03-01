package com.stdio.iptesttask.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
class Item(@PrimaryKey(autoGenerate = true) var id: Int = 0, val name: String, val time: Int, val tags: String, val amount: Int) : Parcelable{
}