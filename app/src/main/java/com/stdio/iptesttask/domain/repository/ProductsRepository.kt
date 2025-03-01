package com.stdio.iptesttask.domain.repository

import com.stdio.iptesttask.domain.model.ItemDomain
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    val allProducts: Flow<List<ItemDomain>>

    suspend fun updateProduct(item: ItemDomain)

    suspend fun deleteProduct(item: ItemDomain)
}