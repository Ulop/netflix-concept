package controls

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import base.Colors

@Composable
fun IconButton(imageVector: ImageVector, onClick: () -> Unit = {}, colorFilter: ColorFilter? = null) {
    Image(
        imageVector,
        null,
        colorFilter = colorFilter ?: ColorFilter.tint(Colors.Primary),
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .clickable(role = Role.Button, onClick = onClick)
    )
}
