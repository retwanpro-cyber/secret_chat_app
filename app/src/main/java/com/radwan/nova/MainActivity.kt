package com.radwan.nova

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.radwan.nova.ui.navigation.AppNavigation
import com.radwan.nova.ui.theme.NOVAChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NOVAChatTheme {
                AppNavigation()
            }
        }
    }
}
