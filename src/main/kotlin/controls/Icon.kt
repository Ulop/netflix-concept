import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun Icon(
    path: String,
    contentDescription: String = "",
    contentScale: ContentScale = ContentScale.Fit,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painterResource(path),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
        colorFilter = colorFilter
    )
}