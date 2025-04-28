package kz.vrstep.android_midterm.domain.repository

import kotlinx.coroutines.flow.Flow
import kz.vrstep.android_midterm.domain.model.Player

interface PlayerRepository {
    fun getPlayers(): Flow<List<Player>>
    suspend fun insertPlayer(player: Player)
}