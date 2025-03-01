package com.stdio.iptesttask.data

import com.stdio.iptesttask.domain.model.Item
import com.stdio.iptesttask.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productDAO: ProductDAO) : ProductsRepository {

    override val allProducts: Flow<List<Item>> = productDAO.getAllProducts()

    override suspend fun updateProduct(item: Item) {
        productDAO.update(item)
    }

    override suspend fun deleteProduct(item: Item) {
        productDAO.delete(item)
    }
}