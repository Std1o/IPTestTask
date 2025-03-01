package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stdio.iptesttask.domain.model.ItemDomain
import com.stdio.iptesttask.extensions.iTems
import com.stdio.iptesttask.presentation.ui.components.SearchAppBar
import com.stdio.iptesttask.presentation.ui.theme.White
import com.stdio.iptesttask.presentation.viewmodel.ProductViewModel

@Composable
fun MainScreen() {
    val viewModel = hiltViewModel<ProductViewModel>()
    val list = viewModel.items.collectAsState(emptyList()).value
    var showChangeAmountDialog by rememberSaveable { mutableStateOf(false) }
    var showDeleteItemDialog by rememberSaveable { mutableStateOf(false) }
    var selectedItem by rememberSaveable { mutableStateOf(ItemDomain(0, "", "", emptyList(), 0)) }
    var selectedAmount by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchAppBar {
                viewModel.prefix = it
            }
        }) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            iTems(list, key = { it }) { item ->
                val shape = RoundedCornerShape(5.dp)
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    shape = shape,
                    colors = CardDefaults.cardColors(
                        containerColor = White,
                    ),
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
                        MainFirstRow(item, onDelete = {
                            showDeleteItemDialog = true
                            selectedItem = it
                        }) { amount, item ->
                            showChangeAmountDialog = true
                            selectedAmount = amount
                            selectedItem = item
                        }
                        MainSecondRow(item)
                        MainThirdRow(item)
                    }
                }
            }
        }

        if (showChangeAmountDialog) {
            AlertChangeAmountDialog(
                amount = selectedAmount,
                onDismissRequest = { showChangeAmountDialog = false }) {
                selectedAmount = it
                viewModel.updateAmount(it, selectedItem)
            }
        }

        if (showDeleteItemDialog) {
            AlertDeleteItemDialog(
                item = selectedItem,
                onDismissRequest = { showDeleteItemDialog = false }) {
                viewModel.deleteItem(it)
            }
        }
        }
}