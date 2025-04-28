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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import kz.vrstep.android_midterm.data.local.AppDatabase
import kz.vrstep.android_midterm.domain.model.Player
import kz.vrstep.android_midterm.viewmodel.PlayersViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun ImagesScreen(viewModel: PlayersViewModel = koinViewModel()) {
    val players = viewModel.players.collectAsState().value

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Favorite Football Team",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Football is my favorite sport, and I love watching my favorite team games. These are some of the top players that enjoy to watch them play",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (!expanded) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(players.take(3)) { index, player ->
                    val width = if (index == 2) 180.dp else 200.dp
                    ImageCard(player.imageUrl, player.wikiUrl, width)
                }
            }
        } else {
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
                                    .weight(1f)
                            ) {
                                ImageCard(player.imageUrl, player.wikiUrl, width = 160.dp)
                            }
                        }
                        if (rowPlayers.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { expanded = !expanded }) {
            Text(if (expanded) "Collapse" else "Show All")
        }
    }
}
