package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.stdio.iptesttask.R
import com.stdio.iptesttask.domain.model.ItemDomain
import com.stdio.iptesttask.presentation.ui.theme.Purple40

@Composable
fun AlertDeleteItemDialog(item: ItemDomain, onDismissRequest: () -> Unit, onConfirm: (ItemDomain) -> Unit) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "Delete Item Icon"
            )
        },
        title = {
            Text(text = stringResource(R.string.deletion_dialog_title))
        },
        text = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = stringResource(R.string.deletion_dialog_description))
            }
        },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(item)
                    onDismissRequest()
                }
            ) {
                Text(stringResource(id = R.string.yes), color = Purple40)
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismissRequest() }
            ) {
                Text(stringResource(id = R.string.no), color = Purple40)
            }
        },
        containerColor = Color.White
    )
}