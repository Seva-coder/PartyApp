package ru.sevastianov.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.sevastianov.repository.entities.TagsEventsCrossRef


@Dao
interface TagEventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tagEventRef: TagsEventsCrossRef)
}