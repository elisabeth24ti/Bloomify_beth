package data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journals")
class JournalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val mood: String,
    val createdAt: Long = System.currentTimeMillis()
)