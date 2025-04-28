package kz.vrstep.android_midterm.data.repository

import kotlinx.coroutines.flow.Flow
import kz.vrstep.android_midterm.data.local.PlayerDao
import kz.vrstep.android_midterm.domain.model.Player
import kz.vrstep.android_midterm.domain.repository.PlayerRepository

class PlayerRepositoryImpl(
    private val dao: PlayerDao
) : PlayerRepository {
    override fun getPlayers(): Flow<List<Player>> = dao.getPlayers()

    override suspend fun insertPlayer(player: Player) = dao.insertPlayer(player)
}