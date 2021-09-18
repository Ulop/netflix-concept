import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuItem(title: String, icon: String, modifier: Modifier = Modifier, selected: Boolean, onClick: () -> Unit) {
    val (hovered, setHovered) = remember{ mutableStateOf(false) }
    val rowModifier = Modifier
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .pointerMoveFilter(
            onEnter = { setHovered(true); true },
            onExit = { setHovered(false); true }
        )
        .background(if (hovered) Color(0x0F7E9EB7) else Color.Unspecified)
        .drawWithContent {
            drawContent()
            if (selected) {
                drawRoundRect(
                    Color(0xFFB91E22),
                    topLeft = Offset(0f, 8f),
                    size = this.size.copy(width = 4f, this.size.height - 16),
                    cornerRadius = CornerRadius(2f, 2f)
                )
            }
        }
        .then(modifier)

    Row(rowModifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            icon,
            modifier = Modifier.size(24.dp),
            colorFilter = if (selected) ColorFilter.tint(Color(0xFFB91E22)) else ColorFilter.tint(Color(0xFFA3ABAE))
        )
        Spacer(Modifier.width(16.dp))
        Text(
            title,
            color = Color(0xFF808B8F),
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}