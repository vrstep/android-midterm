package kz.vrstep.android_midterm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val position: String,
    val nationality: String,
    val team: String,
    val wikiUrl: String,
    val imageUrl: String
)