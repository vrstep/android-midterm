package kz.vrstep.android_midterm.di

import androidx.room.Room
import kz.vrstep.android_midterm.data.local.AppDatabase
import kz.vrstep.android_midterm.data.repository.PlayerRepositoryImpl
import kz.vrstep.android_midterm.domain.usecase.GetPlayersUseCase
import kz.vrstep.android_midterm.domain.usecase.InsertPlayerUseCase
import kz.vrstep.android_midterm.domain.repository.PlayerRepository
import kz.vrstep.android_midterm.viewmodel.PlayersViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Database
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "players_db"
        ).build()
    }

    single { get<AppDatabase>().playerDao() }

    // Repository
    single<PlayerRepository> { PlayerRepositoryImpl(get()) }

    // ViewModel
    viewModel { PlayersViewModel(get()) }

    // UseCases
    single { GetPlayersUseCase(get()) }
    single { InsertPlayerUseCase(get()) }
}