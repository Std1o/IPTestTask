package com.stdio.iptesttask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemDomain(
    val id: Int = 0,
    val name: String,
    val time: String,
    val tags: List<String>,
    val amount: Int
) : Parcelable {
}