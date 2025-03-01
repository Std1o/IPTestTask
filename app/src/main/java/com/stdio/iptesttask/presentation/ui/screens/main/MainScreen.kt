package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stdio.iptesttask.extensions.iTems
import com.stdio.iptesttask.presentation.ui.theme.Purple40
import com.stdio.iptesttask.presentation.ui.theme.White
import com.stdio.iptesttask.presentation.viewmodel.ProductViewModel
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalLayoutApi::class)
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
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(item.name, fontWeight = FontWeight.Bold)
                        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit Icon",
                                tint = Purple40
                            )
                            Icon(
                                modifier = Modifier.padding(start = 10.dp),
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Icon",
                                tint = Color.Red
                            )
                        }
                    }
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(7.dp),
                        verticalArrangement = Arrangement.spacedBy(7.dp),
                    ) {
                        item.tags.split(",").forEach { tag ->
                            OutlinedButton(
                                modifier = Modifier.height(30.dp),
                                onClick = {}, shape = RoundedCornerShape(16),
                                contentPadding = PaddingValues(
                                    vertical = 0.dp,
                                    horizontal = 10.dp
                                )
                            ) {
                                Text(
                                    tag.replace("[", "")
                                        .replace("\"", "")
                                        .replace("]", "")
                                )
                            }
                        }
                    }
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column {
                            Text("На складе", fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
                            Text(item.amount.toString(), fontSize = 13.5.sp)
                        }
                        Column(modifier = Modifier.align(Alignment.CenterEnd)) {
                            Text("Дата добавления", fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
                            Text(convertLongToTime(item.time), fontSize = 13.5.sp)
                        }
                    }
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