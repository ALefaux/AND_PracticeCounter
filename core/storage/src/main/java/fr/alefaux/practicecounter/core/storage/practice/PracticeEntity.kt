package fr.alefaux.practicecounter.core.storage.practice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PracticeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_NAME_ID)
    val id: Int? = null,
    @ColumnInfo(name = COLUMN_NAME_TITLE)
    val title: String,
    @ColumnInfo(name = COLUMN_NAME_OBJECTIVE)
    val objective: Int?,
    @ColumnInfo(name = COLUMN_NAME_VISIBLE)
    val deleted: Boolean = false
) {
    companion object {
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_OBJECTIVE = "objective"
        const val COLUMN_NAME_VISIBLE = "deleted"
    }
}
