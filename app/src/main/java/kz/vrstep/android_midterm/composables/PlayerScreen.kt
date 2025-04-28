package kz.vrstep.android_midterm.composables


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.vrstep.android_midterm.domain.model.Player
import kz.vrstep.android_midterm.viewmodel.PlayersViewModel
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlayersScreen(viewModel: PlayersViewModel = koinViewModel()) {
    val players = viewModel.players.collectAsState().value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(players) { player ->
            PlayerCard(player)
        }
    }
}