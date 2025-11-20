package fr.alefaux.practicecounter.core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.alefaux.practicecounter.core.storage.converter.DateConverters
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao
import fr.alefaux.practicecounter.core.storage.practice.PracticeEntity
import fr.alefaux.practicecounter.core.storage.seance.SeanceEntity

@Database(
    entities = [PracticeEntity::class, SeanceEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(DateConverters::class)
abstract class PracticeCounterDatabase : RoomDatabase() {
    abstract fun practiceDao(): PracticeDao
}
