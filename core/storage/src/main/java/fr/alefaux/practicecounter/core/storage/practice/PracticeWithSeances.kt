package fr.alefaux.practicecounter.core.storage.practice

import androidx.room.Embedded
import androidx.room.Relation
import fr.alefaux.practicecounter.core.storage.seance.SeanceEntity

data class PracticeWithSeances(
    @Embedded
    val practice: PracticeEntity,
    @Relation(
        parentColumn = PracticeEntity.COLUMN_NAME_ID,
        entityColumn = SeanceEntity.COLUMN_NAME_PRACTICE,
    )
    val seances: List<SeanceEntity>,
)
