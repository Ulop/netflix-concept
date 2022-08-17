@file:OptIn(ExperimentalAnimationApi::class)

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.Colors

@ExperimentalComposeUiApi
@Composable
fun MenuItem(
    title: String,
    icon: String,
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    compact: Boolean
) {
    val rowModifier = Modifier
        .clickable(onClick = onClick)
        .drawWithContent {
            drawContent()
            if (selected) {
                drawRoundRect(
                    Colors.DarkRed,
                    topLeft = Offset(0f, 8f),
                    size = this.size.copy(width = 4f, this.size.height - 16),
                    cornerRadius = CornerRadius(2f, 2f)
                )
            }
        }
        .padding(horizontal = 24.dp, vertical = 8.dp)
        .then(modifier)

    Row(rowModifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            icon,
            modifier = Modifier.size(24.dp),
            colorFilter = if (selected) ColorFilter.tint(Colors.DarkRed) else ColorFilter.tint(Colors.Primary)
        )
        AnimatedVisibility(!compact) {
            Row {
                Spacer(Modifier.width(16.dp))
                Text(
                    title,
                    color = Colors.Primary,
                    fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                    fontSize = 16.sp,
                )
            }
        }
    }
}