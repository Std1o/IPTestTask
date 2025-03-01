package com.stdio.iptesttask.data.mapper

import com.stdio.iptesttask.data.model.Item
import com.stdio.iptesttask.domain.Mapper
import com.stdio.iptesttask.domain.model.ItemDomain
import java.text.SimpleDateFormat
import java.util.Date

class ItemMapper : Mapper<Item, ItemDomain> {
    override fun map(input: Item): ItemDomain {
        val tags = input.tags.replace("[", "")
            .replace("\"", "")
            .replace("]", "")
        val time = convertLongToTime(input.time)
        return ItemDomain(
            id = input.id,
            name = input.name,
            time = time,
            tags = tags.split(",").filter { it.isNotEmpty() },
            amount = input.amount
        )
    }
}

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.format(date)
}