package kz.vrstep.android_midterm.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.vrstep.android_midterm.model.Player

@Composable
fun PlayersScreen() {
    val players = listOf(
        Player("Lionel Messi", "Forward", "Argentina", "Inter Miami"),
        Player("Cristiano Ronaldo", "Forward", "Portugal", "Al Nassr"),
        Player("Kylian Mbappé", "Forward", "France", "PSG"),
        Player("Kevin De Bruyne", "Midfielder", "Belgium", "Manchester City"),
        Player("Virgil van Dijk", "Defender", "Netherlands", "Liverpool")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(players) { player ->
            PlayerCard(player)
        }
    }
}