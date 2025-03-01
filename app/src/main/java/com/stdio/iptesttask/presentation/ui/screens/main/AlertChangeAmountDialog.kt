package com.stdio.iptesttask.presentation.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stdio.iptesttask.R
import com.stdio.iptesttask.presentation.ui.components.CircleMinus
import com.stdio.iptesttask.presentation.ui.components.CirclePlus
import com.stdio.iptesttask.presentation.ui.theme.Purple40

@Composable
fun AlertChangeAmountDialog(amount: Int, onDismissRequest: () -> Unit, onConfirm: (Int) -> Unit) {
    var localAmount by rememberSaveable { mutableIntStateOf(amount) }
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
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Icon(
                    imageVector = CircleMinus,
                    contentDescription = "Change Amount Icon",
                    tint = Purple40,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { --localAmount }
                )
                Text(
                    localAmount.toString(),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    fontSize = 30.sp
                )
                Icon(
                    imageVector = CirclePlus,
                    contentDescription = "Change Amount Icon",
                    tint = Purple40,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { ++localAmount }
                )
            }
        },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(localAmount)
                    onDismissRequest()
                }
            ) {
                Text(stringResource(id = R.string.apply), color = Purple40)
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismissRequest() }
            ) {
                Text(stringResource(id = R.string.cancel), color = Purple40)
            }
        },
        containerColor = Color.White
    )
}