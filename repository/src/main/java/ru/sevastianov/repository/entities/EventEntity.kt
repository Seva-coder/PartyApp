package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "events",
    foreignKeys = [
        ForeignKey(
            entity = GroupEntity::class,
            parentColumns = arrayOf("group_id"),
            childColumns = arrayOf("group_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class EventEntity(
    @ColumnInfo(name = "event_id") @PrimaryKey(autoGenerate = true) val eventId: Long,
    @ColumnInfo(name = "logo_url") val logoUrl: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date_unix_time") val dateUnix: Int,
    @ColumnInfo(name = "place") val place: String,
    @ColumnInfo(name = "is_big") val isBig: Boolean,
    @ColumnInfo(name = "metro_name") val metroName: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "i_am_going") val iGo: Boolean,
    @ColumnInfo(name = "free_spaces") val freeSpaces: Int,
    @ColumnInfo(name = "lat") val lat: Double,
    @ColumnInfo(name = "lon") val lon: Double,
    @ColumnInfo(name = "speaker_name") val speakerName: String,
    @ColumnInfo(name = "speaker_description") val speakerDescription: String,
    @ColumnInfo(name = "speaker_img_url") val speakerImgUrl: String,
    @ColumnInfo(name = "group_id") val groupId: Long,
)