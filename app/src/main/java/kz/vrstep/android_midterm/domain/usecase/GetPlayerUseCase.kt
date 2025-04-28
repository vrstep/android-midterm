package kz.vrstep.android_midterm.domain.usecase

import kotlinx.coroutines.flow.Flow
import kz.vrstep.android_midterm.domain.model.Player
import kz.vrstep.android_midterm.domain.repository.PlayerRepository

class GetPlayersUseCase(private val repository: PlayerRepository) {
    operator fun invoke(): Flow<List<Player>> = repository.getPlayers()
}
