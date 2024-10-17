package ru.sevastianov.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.sevastianov.repository.entities.EventDetails
import ru.sevastianov.repository.entities.EventEntity
import ru.sevastianov.repository.entities.EventWithTags


@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(eventDao: EventEntity)

    @Query("SELECT * FROM events WHERE is_big = 1")
    fun getAllBigEvents(): Flow<List<EventWithTags>>

    @Query("SELECT * FROM events WHERE date_unix_time >= (:afterTime) ORDER BY date_unix_time ASC")
    fun getNearestEvents(afterTime: Int): Flow<List<EventWithTags>>

    @Query("SELECT * FROM events ORDER BY date_unix_time ASC")
    fun getAllEvents(): Flow<List<EventWithTags>>

    @Query(
        "SELECT * FROM events JOIN TagsEventsCrossRef ON events.event_id = TagsEventsCrossRef.event_id " +
                "JOIN tags ON tags.tag_id = TagsEventsCrossRef.tag_id WHERE tags.tag_id IN (:idList) " +
                "GROUP BY events.event_id ORDER BY date_unix_time ASC"
    )
    fun getAllEventsByTagIds(idList: List<Long>): Flow<List<EventWithTags>>

    @Query("SELECT * FROM events WHERE name LIKE (:filterText) ORDER BY date_unix_time ASC")
    fun getEventsFiltredByText(filterText: String): Flow<List<EventWithTags>>

    @Query("SELECT * FROM events WHERE event_id = (:eventId)")
    fun getEventDetails(eventId: Long): Flow<EventDetails>

    @Query("UPDATE events SET i_am_going = (:subscription) WHERE event_id = (:eventId)")
    fun setEventSubscription(eventId: Long, subscription: Boolean)

    @Query("SELECT i_am_going FROM events WHERE event_id = (:eventId)")
    fun getEventSubscription(eventId: Long): Flow<Boolean>

    @Query("SELECT * FROM events WHERE group_id = (SELECT group_id FROM events WHERE event_id = (:eventId))")
    fun getGroupEventsByEventId(eventId: Long): Flow<List<EventWithTags>>
}