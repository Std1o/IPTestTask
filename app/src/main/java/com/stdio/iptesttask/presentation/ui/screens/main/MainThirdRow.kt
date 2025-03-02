package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.stdio.iptesttask.R
import com.stdio.iptesttask.domain.model.ItemDomain

@Composable
fun MainThirdRow(item: ItemDomain) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Text(stringResource(R.string.amount), fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
            Text(item.amount.toString(), fontSize = 13.5.sp)
        }
        Column(modifier = Modifier.align(Alignment.CenterEnd)) {
            Text(stringResource(R.string.date), fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
            Text(item.time, fontSize = 13.5.sp)
        }
    }
}