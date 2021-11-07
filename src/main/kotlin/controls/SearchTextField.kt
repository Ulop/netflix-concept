package controls

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.Colors

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchTextField(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    val focused = interactionSource.collectIsFocusedAsState()
    val borderColor = derivedStateOf { if (focused.value) Colors.PrimaryDark else Colors.Primary }

    BasicTextField(
        value,
        onValueChange = onValueChange,
        textStyle = LocalTextStyle.current.copy(fontSize = 12.sp, color = Colors.Primary),
        singleLine = true,
        modifier = Modifier
            .drawBehind {
                drawRoundRect(
                    borderColor.value,
                    style = Stroke(1f),
                    cornerRadius = CornerRadius(24f, 24f)
                )
            }
            .widthIn(min = 200.dp, max = 256.dp)
            .then(modifier),
        decorationBox = { innerTextField ->
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)) {
                Spacer(Modifier.width(16.dp))
                Image(Icons.Default.Search, null, colorFilter = ColorFilter.tint(Colors.Primary))
                Spacer(Modifier.width(8.dp))
                Box {
                    innerTextField()
                }
                Spacer(Modifier.weight(1f))
                AnimatedVisibility(
                    value.isNotEmpty(),
                    enter = scaleIn(),
                    exit = scaleOut()
                ) {
                    IconButton(
                        Icons.Default.Close,
                        onClick = { onValueChange("") }
                    )
                }
                Spacer(Modifier.width(16.dp))
            }
        },
        interactionSource = interactionSource
    )
}

@Preview
@Composable
fun SearchTextFieldPreview2() {
    Box {
        SearchTextField(
            "Some query!",
            onValueChange = {},
            modifier = Modifier.widthIn(400.dp, 700.dp)
        )
    }
}