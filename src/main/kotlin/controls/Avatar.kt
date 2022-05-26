package controls

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import base.Colors

@Composable
fun Avatar(
    path: String,
    contentDescription: String = "",
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    Box(modifier) {
        Canvas(Modifier.padding(4.dp).fillMaxSize()) {
            drawArc(
                SolidColor(Colors.PrimaryLight),
                325f, 75f, false,
                style = Stroke(3f, cap = StrokeCap.Round)
            )
            drawArc(
                SolidColor(Colors.DarkRed),
                148f, 175f, false,
                style = Stroke(4f, cap = StrokeCap.Round)
            )
        }
        Image(
            painter = painterResource(path),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(100)),
            colorFilter = colorFilter
        )
    }
}

@Composable
@Preview()
fun AvatarPreview() {
    Avatar("avatars/female.png", modifier = Modifier.size(96.dp))
}