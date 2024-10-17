package ru.sevastianov.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.sevastianov.repository.entities.TagsGroupsCrossRef


@Dao
interface TagGroupDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tagGroupRef: TagsGroupsCrossRef)
}