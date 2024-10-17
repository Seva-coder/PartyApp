package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    primaryKeys = ["user_id", "event_id"],
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = arrayOf("user_id"),
            childColumns = arrayOf("user_id"),
        ),
        ForeignKey(
            entity = EventEntity::class,
            parentColumns = arrayOf("event_id"),
            childColumns = arrayOf("event_id"),
        ),
    ]
)
class UsersEventsCrossRef(
    @ColumnInfo(name = "user_id") val userId: Long,
    @ColumnInfo(name = "event_id") val eventId: Long
)