package com.radwan.nova.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = ElectricBlue,
    secondary = CyanAccent,
    background = AmoledBlack,
    surface = DarkSlate,
    onBackground = TextWhite,
    onSurface = TextWhite
)

@Composable
fun NOVAChatTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
