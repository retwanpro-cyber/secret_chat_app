package com.radwan.nova.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.radwan.nova.R

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = stringResource(R.string.settings))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Lead Developer: " + stringResource(R.string.developer))
        Text(text = stringResource(R.string.copyright))
    }
}
