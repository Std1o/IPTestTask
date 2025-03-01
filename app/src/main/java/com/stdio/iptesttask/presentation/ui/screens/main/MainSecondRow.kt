package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stdio.iptesttask.domain.model.ItemDomain

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainSecondRow(item: ItemDomain) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp),
    ) {
        item.tags.forEach { tag ->
            OutlinedButton(
                modifier = Modifier.height(30.dp),
                onClick = {}, shape = RoundedCornerShape(16),
                contentPadding = PaddingValues(
                    vertical = 0.dp,
                    horizontal = 10.dp
                )
            ) {
                Text(tag)
            }
        }
    }
}