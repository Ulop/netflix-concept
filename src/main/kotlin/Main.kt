// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import controls.sidemenu.SideMenu
import controls.sidemenu.SideMenuItem

@Composable
@Preview
fun App() {
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
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                "Choose category",
                color = Color(0xFF808B8F),
                fontSize = 36.sp
            )
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
        withStyle(SpanStyle(color = Color.Red)) {
            append(".")
        }
    }, color = Color(0xFF35424B), fontSize = 48.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(padding))
}

fun Modifier.mainBackground() = background(Brush.verticalGradient(listOf(
    Color(0xFFFAFBFF),
    Color(0xFFF7F7F7),
    Color(0xFFF5F5FD)
)))