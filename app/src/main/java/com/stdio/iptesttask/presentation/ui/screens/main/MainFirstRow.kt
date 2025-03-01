package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.stdio.iptesttask.domain.model.Item
import com.stdio.iptesttask.presentation.ui.theme.Purple40

@Composable
fun MainFirstRow(item: Item, onEdit: (Int) -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(item.name, fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Icon",
                tint = Purple40,
                modifier = Modifier.clickable { onEdit(item.amount) }
            )
            Icon(
                modifier = Modifier.padding(start = 10.dp),
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Icon",
                tint = Color.Red
            )
        }
    }
}