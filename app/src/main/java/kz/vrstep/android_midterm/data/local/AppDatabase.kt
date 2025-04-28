package kz.vrstep.android_midterm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.vrstep.android_midterm.domain.model.Player

@Database(entities = [Player::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}