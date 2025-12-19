package fr.alefaux.practicecounter.core.storage.practice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PracticeDao {
    @Query("SELECT * FROM PracticeEntity")
    fun getAll(): List<PracticeEntity>

    @Transaction
    @Query("SELECT * FROM PracticeEntity")
    fun getAllWithSeances(): Flow<List<PracticeWithSeances>>

    @Query("SELECT * FROM PracticeEntity WHERE id = :id LIMIT 1")
    fun findPracticeById(id: Int): PracticeEntity?

    @Transaction
    @Query("SELECT * FROM PracticeEntity WHERE id = :id LIMIT 1")
    fun findPracticeAndSeanceById(id: Int): PracticeWithSeances?

    @Transaction
    @Query("SELECT * FROM PracticeEntity WHERE id = :id LIMIT 1")
    fun findPracticeAndSeanceByIdFlow(id: Int): Flow<PracticeWithSeances?>

    @Insert
    fun insert(practice: PracticeEntity)

    @Update
    fun update(practice: PracticeEntity)

    @Delete
    fun delete(practice: PracticeEntity)
}
