package com.stdio.iptesttask.data.repository

import com.stdio.iptesttask.data.ProductDAO
import com.stdio.iptesttask.data.mapper.ItemMapper
import com.stdio.iptesttask.data.mapper.ItemReverseMapper
import com.stdio.iptesttask.domain.model.ItemDomain
import com.stdio.iptesttask.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productDAO: ProductDAO) :
    ProductsRepository {

    override val allProducts: Flow<List<ItemDomain>> = productDAO.getAllProducts().map { list ->
        list.map { item ->
            val itemMapper = ItemMapper()
            itemMapper.map(item)
        }
    }

    override suspend fun updateProduct(item: ItemDomain) {
        val itemReverseMapper = ItemReverseMapper()
        productDAO.update(itemReverseMapper.map(item))
    }

    override suspend fun deleteProduct(item: ItemDomain) {
        val itemReverseMapper = ItemReverseMapper()
        productDAO.delete(itemReverseMapper.map(item))
    }
}