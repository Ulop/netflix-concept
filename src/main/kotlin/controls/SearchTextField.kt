package controls

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import base.Colors

@Composable
fun SearchTextField(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    BasicTextField(
        value,
        onValueChange = onValueChange,
        textStyle = LocalTextStyle.current.copy(fontSize = 12.sp, color = Colors.Primary),
        singleLine = true,
        modifier = Modifier
            .drawBehind {
                drawRoundRect(Colors.Primary, style = Stroke(1f), cornerRadius = CornerRadius(24f, 24f))
            }
            .widthIn(min = 256.dp)
            .then(modifier),
        decorationBox = { innerTextField ->
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)) {
                Spacer(Modifier.width(16.dp))
                Image(Icons.Default.Search, null, colorFilter = ColorFilter.tint(Colors.Primary))
                Spacer(Modifier.width(8.dp))
                innerTextField()
                Spacer(Modifier.width(16.dp))
            }
        }
    )
}