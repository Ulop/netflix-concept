package controls.sidemenu

import LocalRootWindowSize
import MenuItem
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import base.Colors


sealed class SideMenuItem {
    class ClickableItem(
        val title: String,
        val icon: String = "",
        val onClick: () -> Unit = {}
    ) : SideMenuItem()

    class GroupHeader(val title: String) : SideMenuItem()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SideMenu(
    vararg menuItems: SideMenuItem,
    modifier: Modifier = Modifier,
    header: @Composable ColumnScope.() -> Unit = {}
) {
    val (selectedIndex, setSelectedIndex) = remember { mutableStateOf(-1) }
    val width = LocalRootWindowSize.current.width
    val compact = remember(width) { width < 600.dp }

    val columnModifier = Modifier
        .animateContentSize()
        .drawWithContent {
            drawContent()
            drawLine(
                Colors.Outline,
                start = Offset(this.size.width - 2, 0f),
                end = Offset(this.size.width - 2, this.size.height)
            )
        }
        .widthIn(min = 48.dp, max = 260.dp)
        .width(IntrinsicSize.Max)
        .fillMaxHeight()
        .then(modifier)

    Column(columnModifier) {
        header(this)
        menuItems.forEachIndexed { index, item ->
            when (item) {
                is SideMenuItem.ClickableItem -> {
                    MenuItem(
                        item.title,
                        item.icon,
                        onClick = {
                            setSelectedIndex(index)
                            item.onClick()
                        },
                        selected = index == selectedIndex,
                        compact = compact
                    )
                }
                is SideMenuItem.GroupHeader -> {
                    if (item.title.isNotEmpty()) {
                        Text(
                            if (!compact) item.title else "",
                            modifier = Modifier.padding(start = 32.dp, top = 16.dp, bottom = 16.dp),
                            color = Colors.Primary
                        )
                    }
                }
            }
        }
    }
}