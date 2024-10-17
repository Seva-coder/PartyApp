package ru.sevastianov.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.sevastianov.repository.entities.GroupEntity


@Dao
interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(group: GroupEntity)

    @Query("SELECT * FROM groups WHERE group_id = (SELECT group_id FROM events WHERE event_id = (:eventId))")
    fun getGroupDescriptionByEventId(eventId: Long): Flow<GroupEntity>

}