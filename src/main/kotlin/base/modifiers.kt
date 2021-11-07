package base

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.mainBackground() = background(
    Brush.verticalGradient(
        listOf(
            Color(0xFFFAFBFF),
            Color(0xFFF7F7F7),
            Color(0xFFF5F5FD)
        )
    )
)