package com.radwan.nova.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.radwan.nova.R

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text(stringResource(R.string.app_name)) })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text(text = stringResource(R.string.chats))
            Button(onClick = { navController.navigate("chat/123") }) {
                Text("Open Demo Chat")
            }
        }
    }
}
