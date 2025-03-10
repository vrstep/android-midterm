package kz.vrstep.android_midterm.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.vrstep.android_midterm.model.Player

@Composable
fun ImagesScreen() {
    val players = listOf(
        Player("Vinícius Júnior", "Forward", "Brazil", "Real Madrid", "https://en.wikipedia.org/wiki/Vin%C3%ADcius_J%C3%BAnior", "https://assets.laliga.com/squad/2024/t178/p593109/2048x2225/p593109_t178_2024_1_001_000.png"),
        Player("Jude Bellingham", "Midfielder", "England", "Real Madrid", "https://en.wikipedia.org/wiki/Jude_Bellingham", "https://assets.laliga.com/squad/2024/t178/p490541/2048x2225/p490541_t178_2024_1_001_000.png"),
        Player("Toni Kroos", "Midfielder", "Germany", "Real Madrid", "https://en.wikipedia.org/wiki/Toni_Kroos", "https://assets.laliga.com/squad/2024/t178/p219961/2048x2225/p219961_t178_2024_1_001_000.png"),
        Player("Luka Modrić", "Midfielder", "Croatia", "Real Madrid", "https://en.wikipedia.org/wiki/Luka_Modri%C4%87", "https://assets.laliga.com/squad/2024/t178/p56764/2048x2225/p56764_t178_2024_1_001_000.png"),
        Player("Rodrygo", "Forward", "Brazil", "Real Madrid", "https://en.wikipedia.org/wiki/Rodrygo", "https://assets.laliga.com/squad/2024/t178/p209712/2048x2225/p209712_t178_2024_1_001_000.png"),
        Player("Eduardo Camavinga", "Midfielder", "France", "Real Madrid", "https://en.wikipedia.org/wiki/Eduardo_Camavinga", "https://assets.laliga.com/squad/2024/t178/p224444/2048x2225/p224444_t178_2024_1_001_000.png"),
        Player("Aurélien Tchouaméni", "Midfielder", "France", "Real Madrid", "https://en.wikipedia.org/wiki/Aur%C3%A9lien_Tchouam%C3%A9ni", "https://assets.laliga.com/squad/2024/t178/p593110/2048x2225/p593110_t178_2024_1_001_000.png")
    )

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Favorite Football Team",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Football is my favorite sport, and I love watching my favorite team games. These are some of the top players that enjoy to watch them play",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (!expanded) {
            // Horizontal carousel (first 3 images, last one slightly visible)
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(players.take(3)) { index, player ->
                    val width = if (index == 2) 180.dp else 200.dp // Show glimpse of 3rd image
                    ImageCard(player.imageUrl, player.wikiUrl, width)
                }
            }
        } else {
            // Grid layout (2 images per row) with equal-sized columns
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                itemsIndexed(players.chunked(2)) { _, rowPlayers ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        rowPlayers.forEach { player ->
                            Box(
                                modifier = Modifier
                                    .weight(1f) // Ensures equal width for both images
                            ) {
                                ImageCard(player.imageUrl, player.wikiUrl, width = 160.dp)
                            }
                        }
                        if (rowPlayers.size == 1) {
                            // If there's an odd number of items, add an empty spacer to balance the row
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Ensure button is always visible
        Button(onClick = { expanded = !expanded }) {
            Text(if (expanded) "Collapse" else "Show All")
        }
    }
}
