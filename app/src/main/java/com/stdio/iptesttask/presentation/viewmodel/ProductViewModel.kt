package com.stdio.iptesttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stdio.iptesttask.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.allProducts.collect {
                println(it)
            }
        }
    }
}