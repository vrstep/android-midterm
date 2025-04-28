package kz.vrstep.android_midterm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kz.vrstep.android_midterm.domain.model.Player
import kz.vrstep.android_midterm.domain.usecase.GetPlayersUseCase

class PlayersViewModel(
    getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {
    val players: StateFlow<List<Player>> = getPlayersUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}