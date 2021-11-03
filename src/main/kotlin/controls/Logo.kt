package controls

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.Colors
import base.LocalRootWindowSize

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Logo(padding: PaddingValues = PaddingValues(0.dp), modifier: Modifier = Modifier) {
    val width = LocalRootWindowSize.current.width
    val compact = remember(width) { width < 600.dp }
    val calculatedPadding = remember(compact) {
        if (compact)
            PaddingValues(horizontal = 8.dp, vertical = padding.calculateBottomPadding())
        else
            padding
    }

    val text = remember(compact) {
        if (compact) {
            buildAnnotatedString {
                withStyle(SpanStyle(color = Colors.DarkRed, fontSize = 56.sp)) {
                    append("N")
                }
            }
        } else {
            buildAnnotatedString {
                append("Netflix")
                withStyle(SpanStyle(color = Colors.DarkRed, fontSize = 56.sp)) {
                    append(".")
                }
            }
        }
    }

    Text(
        text,
        color = Colors.PrimaryDark,
        fontSize = 48.sp,
        fontWeight = FontWeight.SemiBold,
        maxLines = 1,
        modifier = Modifier.padding(calculatedPadding).animateContentSize()
            .then(modifier)//.requiredHeight(48.sp.value.dp)
    )
}