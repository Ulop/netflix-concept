package controls

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import base.Colors

@Composable
fun IconButtonWithBadge(
    imageVector: ImageVector,
    onClick: () -> Unit = {},
    colorFilter: ColorFilter? = null,
    modifier: Modifier? = null
) {
    val path = remember { Path() }
    Image(
        imageVector,
        null,
        colorFilter = colorFilter ?: ColorFilter.tint(Colors.Primary),
        modifier = (modifier ?: Modifier)
            .size(32.dp)
            .clip(CircleShape)
            .clickable(role = Role.Button, onClick = onClick)
            .padding(4.dp)
            .drawWithContent {
                val radius = size.minDimension / 4f
                path.reset()
                path.addOval(Rect(Offset(this.size.width - radius * 1.0f, radius * 1.0f), radius))
                clipPath(path, ClipOp.Difference) {
                    this@drawWithContent.drawContent()
                }
                drawCircle(
                    SolidColor(Colors.DarkRed),
                    radius * 0.65f,
                    Offset(this.size.width - radius * 1.0f, radius * 1.0f),
                )
            }
    )
}