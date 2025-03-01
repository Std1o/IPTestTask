package com.stdio.iptesttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stdio.iptesttask.domain.model.Item
import com.stdio.iptesttask.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    val allProducts = repository.allProducts

    fun updateAmount(amount: Int, item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProduct(item.copy(amount = amount))
        }
    }
}