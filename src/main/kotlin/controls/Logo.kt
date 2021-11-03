package controls

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.Colors

@Composable
fun Logo(padding: PaddingValues = PaddingValues(0.dp)) {
    Text(
        buildAnnotatedString {
            append("Netflix")
            withStyle(SpanStyle(color = Colors.DarkRed)) {
                append(".")
            }
        },
        color = Colors.PrimaryDark,
        fontSize = 48.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(padding)
    )
}