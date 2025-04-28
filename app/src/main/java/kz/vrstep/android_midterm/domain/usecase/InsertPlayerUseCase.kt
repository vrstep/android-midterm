package kz.vrstep.android_midterm.domain.usecase

import kz.vrstep.android_midterm.domain.model.Player
import kz.vrstep.android_midterm.domain.repository.PlayerRepository

class InsertPlayerUseCase(private val repository: PlayerRepository) {
    suspend operator fun invoke(player: Player) = repository.insertPlayer(player)
}