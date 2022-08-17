package controls

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.Colors

@Composable
fun AvatarWithProgress(
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
        Avatar(
            path,
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .padding(10.dp),
            colorFilter = colorFilter
        )
    }
}

@Composable
fun Avatar(
    path: String,
    contentDescription: String = "",
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painterResource(path),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
            .clip(RoundedCornerShape(100)),
        colorFilter = colorFilter
    )
}

@Composable
@Preview()
fun AvatarPreview() {
    Row {
        AvatarWithProgress("avatars/female.png", modifier = Modifier.size(96.dp))
        Spacer(Modifier.width(16.dp))
        Column(Modifier.align(Alignment.CenterVertically)) {
            Text("Ramona F.", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text("Level 12", color = Colors.SecondaryText)
        }
    }
}