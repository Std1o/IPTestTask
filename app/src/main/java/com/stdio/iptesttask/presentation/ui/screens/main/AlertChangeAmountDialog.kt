package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.stdio.iptesttask.R

@Composable
fun AlertChangeAmountDialog(onDismissRequest: () -> Unit) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Change Amount Icon"
            )
        },
        title = {
            Text(text = stringResource(R.string.amount_dialog))
        },
        text = {

        },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(
                onClick = { onDismissRequest() }
            ) {
                Text(stringResource(id = R.string.apply))
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismissRequest() }
            ) {
                Text(stringResource(id = R.string.cancel))
            }
        },
        containerColor = Color.White
    )
}