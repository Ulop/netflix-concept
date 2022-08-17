package controls

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.Colors
import data.User

@Composable
fun UserInfoShort(modifier: Modifier, user: User) {
    val name = remember(user.name, user.sureName) { "${user.name} ${user.sureName[0]}." }
    val level = remember(user.level) { "Level ${user.level}" }

    Row {
        AvatarWithProgress(user.avatar, modifier = modifier)
        Spacer(Modifier.width(8.dp))
        Column(Modifier.align(Alignment.CenterVertically)) {
            Text(
                name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Spacer(Modifier.height(4.dp))
            Text(
                level,
                fontSize = 8.sp,
                color = Colors.SecondaryText,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}