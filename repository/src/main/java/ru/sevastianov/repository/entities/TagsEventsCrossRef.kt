package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    primaryKeys = ["tag_id", "event_id"],
    foreignKeys = [
        ForeignKey(
            entity = EventEntity::class,
            parentColumns = arrayOf("event_id"),
            childColumns = arrayOf("event_id"),
        ),
        ForeignKey(
            entity = TagEntity::class,
            parentColumns = arrayOf("tag_id"),
            childColumns = arrayOf("tag_id"),
        ),
    ]
)
class TagsEventsCrossRef(
    @ColumnInfo(name = "tag_id") val tagId: Long,
    @ColumnInfo(name = "event_id") val eventId: Long,
)