package controls.sidemenu

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp

import MenuItem
import base.Colors


sealed class SideMenuItem {
    class ClickableItem(
        val title: String,
        val icon: String = "",
        val onClick: () -> Unit = {}
    ): SideMenuItem()
    class GroupHeader(val title: String): SideMenuItem()
}

@Composable
fun SideMenu(
    vararg menuItems: SideMenuItem,
    modifier: Modifier = Modifier,
    header: @Composable LazyItemScope.() -> Unit = {}
){
    val (selectedIndex, setSelectedIndex) = remember { mutableStateOf(-1) }

    val columnModifier = Modifier
        .widthIn(128.dp, 256.dp)
        .fillMaxHeight()
        .drawWithContent {
            drawContent()
            drawLine(
                Colors.Outline,
                start = Offset(this.size.width - 1, 0f),
                end = Offset(this.size.width - 1, this.size.height)
            )
        }
        .then(modifier)

    LazyColumn(columnModifier) {
        item("header", header)
        itemsIndexed(menuItems) { index, item ->
            when (item) {
                is SideMenuItem.ClickableItem -> {
                    MenuItem(
                        item.title,
                        item.icon,
                        onClick = {
                            setSelectedIndex(index)
                            item.onClick()
                        },
                        modifier = Modifier.padding(start = 32.dp, top = 8.dp, bottom = 8.dp),
                        selected = index == selectedIndex
                    )
                }
                is SideMenuItem.GroupHeader -> {
                    if (item.title.isNotEmpty()) {
                        Text(
                            item.title,
                            modifier = Modifier.padding(start = 32.dp, top = 16.dp, bottom = 16.dp),
                            color = Colors.Primary
                        )
                    }
                }
            }
        }
    }
}