package fr.alefaux.practicecounter.core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.alefaux.practicecounter.core.storage.practice.PracticeEntity
import fr.alefaux.practicecounter.core.storage.practice.PracticeDao

@Database(entities = [PracticeEntity::class], version = 1, exportSchema = false)
abstract class PracticeCounterDatabase: RoomDatabase() {
    abstract fun practiceDao(): PracticeDao
}