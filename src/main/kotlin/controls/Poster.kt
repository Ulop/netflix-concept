package controls

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import base.Colors
import data.User
import data.getSampleUsersData

data class Recommendation(
    val film: FilmInfo,
    val watchingFriends: List<User>
)

data class FilmInfo(
    val name: String,
    val seasons: Int,
    val match: Float,
    val pointsPerEpisode: Int,
    val poster: String
)

@Composable
fun Poster(recommendation: Recommendation) {

    val friendsToShow = remember(recommendation.watchingFriends) {
        recommendation.watchingFriends.take(
            minOf(
                3,
                recommendation.watchingFriends.size
            )
        )
    }
    val hiddenFriendsCount = derivedStateOf { recommendation.watchingFriends.size - friendsToShow.size }

    Box(
        Modifier
            .aspectRatio(2.4f)
            .clip(RoundedCornerShape(8))
    ) {
        Image(
            painter = painterResource(recommendation.film.poster),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Column(Modifier.fillMaxSize().padding(24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "${recommendation.film.pointsPerEpisode}XP / episode",
                    color = Colors.PrimaryLight.copy(alpha = 0.65f),
                    modifier = Modifier
                        .background(Color(0xFF555E5F), RoundedCornerShape(50))
                        .padding(8.dp)
                )

                Spacer(Modifier.width(16.dp))

                friendsToShow.forEachIndexed { index, it ->
                    Avatar(
                        it.avatar,
                        modifier = Modifier
                            .size(32.dp)
                            .offset((-8 * index).dp)
                            .zIndex((friendsToShow.size - index).toFloat())
                            .border(2.dp, Colors.PrimaryLight.copy(alpha = 0.55f), RoundedCornerShape(50)),
                        contentScale = ContentScale.Crop
                    )
                }

                if (hiddenFriendsCount.value > 0) {
                    Text(
                        "+${hiddenFriendsCount.value} friends are watching",
                        color = Colors.PrimaryLight.copy(alpha = 0.65f),
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            Text(
                recommendation.film.name,
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(Modifier.height(24.dp))

            Row {
                Text(
                    "${recommendation.film.match}% Match",
                    color = Color.White.copy(0.85f),
                    fontSize = 14.sp,
                )

                Spacer(Modifier.width(8.dp))

                Text(
                    "${recommendation.film.seasons} seasons",
                    color = Color.White.copy(0.85f),
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Preview
@Composable
fun PosterPreview() {
    Poster(
        Recommendation(
            FilmInfo(
                "The Witcher",
                seasons = 2,
                match = 98f,
                10,
                "posters/the_witcher.jpg"
            ),
            getSampleUsersData()
        )
    )
}