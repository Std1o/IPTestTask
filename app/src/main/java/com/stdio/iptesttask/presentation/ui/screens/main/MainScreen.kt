package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stdio.iptesttask.extensions.iTems
import com.stdio.iptesttask.presentation.ui.theme.White
import com.stdio.iptesttask.presentation.viewmodel.ProductViewModel
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<ProductViewModel>()
    val list = viewModel.allProducts.collectAsState(emptyList()).value
    LazyColumn(modifier = Modifier.fillMaxSize()) {
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
                    MainFirstRow(item)
                    MainSecondRow(item)
                    MainThirdRow(item)
                }
            }
        }
    }
}

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.format(date)
}