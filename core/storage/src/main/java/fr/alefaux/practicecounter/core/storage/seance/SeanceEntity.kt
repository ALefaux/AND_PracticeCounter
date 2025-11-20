package fr.alefaux.practicecounter.core.storage.seance

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class SeanceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_NAME_ID)
    val id: Int? = null,
    @ColumnInfo(name = COLUMN_NAME_PRACTICE)
    val practiceAssociatedId: Int,
    @ColumnInfo(name = COLUMN_NAME_DATE)
    val date: Date,
    @ColumnInfo(name = COLUMN_NAME_NUMBER)
    val number: Int,
) {
    companion object {
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_PRACTICE = "practice"
        const val COLUMN_NAME_DATE = "date"
        const val COLUMN_NAME_NUMBER = "number"
    }
}
