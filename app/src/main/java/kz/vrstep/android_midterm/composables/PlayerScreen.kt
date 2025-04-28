package kz.vrstep.android_midterm.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.vrstep.android_midterm.domain.model.Player

@Composable
fun PlayersScreen() {
    val players = listOf(
        Player("Vinícius Júnior", "Forward", "Brazil", "Real Madrid", "https://en.wikipedia.org/wiki/Vin%C3%ADcius_J%C3%BAnior", "https://assets.laliga.com/squad/2024/t178/p593109/2048x2225/p593109_t178_2024_1_001_000.png"),
        Player("Jude Bellingham", "Midfielder", "England", "Real Madrid", "https://en.wikipedia.org/wiki/Jude_Bellingham", "https://assets.laliga.com/squad/2024/t178/p490541/2048x2225/p490541_t178_2024_1_001_000.png"),
        Player("Toni Kroos", "Midfielder", "Germany", "Real Madrid", "https://en.wikipedia.org/wiki/Toni_Kroos", "https://assets.laliga.com/squad/2024/t178/p219961/2048x2225/p219961_t178_2024_1_001_000.png"),
        Player("Luka Modrić", "Midfielder", "Croatia", "Real Madrid", "https://en.wikipedia.org/wiki/Luka_Modri%C4%87", "https://assets.laliga.com/squad/2024/t178/p56764/2048x2225/p56764_t178_2024_1_001_000.png"),
        Player("Rodrygo", "Forward", "Brazil", "Real Madrid", "https://en.wikipedia.org/wiki/Rodrygo", "https://assets.laliga.com/squad/2024/t178/p209712/2048x2225/p209712_t178_2024_1_001_000.png"),
        Player("Eduardo Camavinga", "Midfielder", "France", "Real Madrid", "https://en.wikipedia.org/wiki/Eduardo_Camavinga", "https://assets.laliga.com/squad/2024/t178/p224444/2048x2225/p224444_t178_2024_1_001_000.png"),
        Player("Aurélien Tchouaméni", "Midfielder", "France", "Real Madrid", "https://en.wikipedia.org/wiki/Aur%C3%A9lien_Tchouam%C3%A9ni", "https://assets.laliga.com/squad/2024/t178/p593110/2048x2225/p593110_t178_2024_1_001_000.png")
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