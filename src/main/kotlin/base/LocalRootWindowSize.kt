package base

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

val LocalRootWindowSize = staticCompositionLocalOf {
    DpSize(800.dp, 600.dp)
}