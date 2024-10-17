package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Junction
import androidx.room.Relation


data class EventWithTags(
    @ColumnInfo(name = "event_id") val eventId: Long,
    @ColumnInfo(name = "logo_url") val logoUrl: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date_unix_time") val date: Int,
    @ColumnInfo(name = "place") val place: String,
    @Relation(
        parentColumn = "event_id",
        entityColumn = "tag_id",
        associateBy = Junction(TagsEventsCrossRef::class),
        entity = TagEntity::class,
        projection = ["tag_name"]
    )
    val tags: List<String>
)