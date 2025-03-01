package com.stdio.iptesttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stdio.iptesttask.domain.model.ItemDomain
import com.stdio.iptesttask.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    private val _items = MutableStateFlow<List<ItemDomain>>(emptyList())
    val items = _items.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.allProducts("").collect{
                _items.value = it
            }
        }
    }

    var prefix: String by Delegates.observable("") { _, _, new ->
        viewModelScope.launch(Dispatchers.IO) {
            repository.allProducts(new).collect{
                _items.value = it
            }
        }
    }

    fun updateAmount(amount: Int, item: ItemDomain) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProduct(item.copy(amount = amount))
        }
    }

    fun deleteItem(item: ItemDomain) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProduct(item)
        }
    }
}