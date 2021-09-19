// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

import base.Colors
import base.mainBackground
import controls.IconButton
import controls.SearchTextField
import controls.sidemenu.SideMenu
import controls.sidemenu.SideMenuItem

@Composable
@Preview
fun App() {
    val (searchText, setSearchText) = remember { mutableStateOf("") }
    Row(Modifier.fillMaxWidth().mainBackground()) {
        SideMenu(
            SideMenuItem.GroupHeader("Menu"),
            SideMenuItem.ClickableItem("Browse", "icons/explore.svg"),
            SideMenuItem.ClickableItem("Watchlist", "icons/heart.svg"),
            SideMenuItem.ClickableItem("Coming soon", "icons/calendar.svg"),
            SideMenuItem.GroupHeader("Social"),
            SideMenuItem.ClickableItem("Friends", "icons/person.svg"),
            SideMenuItem.ClickableItem("Parties", "icons/groups.svg"),
            SideMenuItem.GroupHeader("General"),
            SideMenuItem.ClickableItem("Settings", "icons/settings.svg"),
            SideMenuItem.ClickableItem("Log out", "icons/logout.svg"),
            header = { Logo(PaddingValues(32.dp)) }
        )
        Box(Modifier.fillMaxSize()) {
            Row(Modifier.heightIn(64.dp, 72.dp).padding(horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(Icons.Default.KeyboardArrowLeft)
                Spacer(Modifier.size(8.dp))
                IconButton(Icons.Default.KeyboardArrowRight)
                Spacer(Modifier.size(24.dp))
                SearchTextField(searchText, setSearchText, Modifier.widthIn(min = 512.dp))
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
fun Logo(padding: PaddingValues = PaddingValues(0.dp)) {
    Text(buildAnnotatedString {
        append("Netflix")
        withStyle(SpanStyle(color = Colors.DarkRed)) {
            append(".")
        }
    }, color = Colors.PrimaryDark, fontSize = 48.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(padding))
}
