package fr.alefaux.practicecounter.core.storage.practice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PracticeDao {
    @Query("SELECT * FROM PracticeEntity")
    fun getAll(): List<PracticeEntity>

    @Query("SELECT * FROM PracticeEntity")
    fun getAllWithSeances(): Flow<List<PracticeWithSeances>>

    @Query("SELECT * FROM PracticeEntity WHERE id = :id LIMIT 1")
    fun findById(id: Int): PracticeEntity

    @Insert
    fun insert(practice: PracticeEntity)

    @Delete
    fun delete(practice: PracticeEntity)
}
