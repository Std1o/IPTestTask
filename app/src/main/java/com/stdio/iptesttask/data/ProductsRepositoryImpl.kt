package com.stdio.iptesttask.data

import com.stdio.iptesttask.domain.model.Item
import com.stdio.iptesttask.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productDAO: ProductDAO) : ProductsRepository {

    override val allProducts: Flow<List<Item>> = productDAO.getAllProducts()

    override suspend fun addProduct(contact: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(contact: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(contact: Item) {
        TODO("Not yet implemented")
    }
}