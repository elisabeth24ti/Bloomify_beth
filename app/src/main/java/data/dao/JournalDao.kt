package data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import data.entity.JournalEntity

@Dao
interface JournalDao {
    @Query("SELECT * FROM journals ORDER BY createdAt DESC")
    suspend fun getAll(): List<JournalEntity>
    @Insert
    suspend fun insert(journal: JournalEntity)
    @Delete
    suspend fun delete(journal: JournalEntity)
}