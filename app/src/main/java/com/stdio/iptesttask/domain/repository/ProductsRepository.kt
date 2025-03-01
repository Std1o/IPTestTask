package com.stdio.iptesttask.domain.repository

import com.stdio.iptesttask.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    val allProducts: Flow<List<Item>>

    suspend fun updateProduct(item: Item)

    suspend fun deleteProduct(item: Item)
}