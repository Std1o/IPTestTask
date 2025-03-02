package com.stdio.iptesttask.data.mapper

import com.stdio.iptesttask.data.model.Item
import com.stdio.iptesttask.domain.Mapper
import com.stdio.iptesttask.domain.model.ItemDomain
import java.text.SimpleDateFormat

class ItemReverseMapper : Mapper<ItemDomain, Item> {
    override fun map(input: ItemDomain): Item {
        val time = convertLongToTime(input.time)
        val tags = input.tags.map { it.trim() }
        return Item(
            id = input.id,
            name = input.name,
            time = time,
            tags = tags.toString(),
            amount = input.amount
        )
    }
}

fun convertLongToTime(time: String): Long {
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.parse(time).time
}