package fr.alefaux.practicecounter.core.storage.practice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PracticeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "objective") val objective: Int?
)