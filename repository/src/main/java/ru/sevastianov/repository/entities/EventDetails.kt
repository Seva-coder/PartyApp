package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Junction
import androidx.room.Relation


data class EventDetails(
    @ColumnInfo(name = "event_id") val eventId: Long,
    @ColumnInfo(name = "logo_url") val logoUrl: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date_unix_time") val date: Int,
    @ColumnInfo(name = "place") val place: String,
    @ColumnInfo(name = "metro_name") val metroName: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "i_am_going") val iGo: Boolean,
    @ColumnInfo(name = "lat") val lat: Double,
    @ColumnInfo(name = "lon") val lon: Double,
    @ColumnInfo(name = "speaker_name") val speakerName: String,
    @ColumnInfo(name = "speaker_description") val speakerDescription: String,
    @ColumnInfo(name = "speaker_img_url") val speakerImg: String,
    @ColumnInfo(name = "free_spaces") val freeSpaces: Int,
    @Relation(
        parentColumn = "event_id",
        entityColumn = "tag_id",
        associateBy = Junction(TagsEventsCrossRef::class),
        entity = TagEntity::class,
        projection = ["tag_name"]
    )
    val tags: List<String>
)