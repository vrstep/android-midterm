package kz.vrstep.android_midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import kz.vrstep.android_midterm.composables.MainScreen
import kz.vrstep.android_midterm.data.local.PlayerDao
import kz.vrstep.android_midterm.domain.model.Player
import kz.vrstep.android_midterm.ui.theme.AndroidmidtermTheme
import org.koin.android.ext.android.get

suspend fun populateDatabase(playerDao: PlayerDao) {
    val players = listOf(
        Player(name = "Lamine Yamal", position = "Forward", nationality = "Spain", team = "Barcelona",
            wikiUrl = "https://en.wikipedia.org/wiki/Lamine_Yamal", imageUrl = "https://assets.laliga.com/squad/2024/t178/p593109/2048x2225/p593109_t178_2024_1_001_000.png"),
        Player(name = "Pedri", position = "Midfielder", nationality = "Spain", team = "Barcelona",
            wikiUrl = "https://en.wikipedia.org/wiki/Pedri", imageUrl = "https://assets.laliga.com/squad/2024/t178/p490541/2048x2225/p490541_t178_2024_1_001_000.png"),
        Player(name = "Raphinha", position = "Winger", nationality = "Brazil", team = "Barcelona",
            wikiUrl = "https://en.wikipedia.org/wiki/Raphinha", imageUrl = "https://assets.laliga.com/squad/2024/t178/p219961/2048x2225/p219961_t178_2024_1_001_000.png"),
        // Add the rest players you have...
    )

    players.forEach { player ->
        playerDao.insertPlayer(player)
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val playerDao = get<PlayerDao>()

        setContent {
            AndroidmidtermTheme {
                MainScreen()

                LaunchedEffect(Unit) {
                    populateDatabase(playerDao)
                }
            }
        }
    }
}