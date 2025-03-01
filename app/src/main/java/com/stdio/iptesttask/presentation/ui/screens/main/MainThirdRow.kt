package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.stdio.iptesttask.domain.model.Item

@Composable
fun MainThirdRow(item: Item) {
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