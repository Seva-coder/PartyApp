package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    primaryKeys = ["tag_id", "group_id"],
    foreignKeys = [
        ForeignKey(
            entity = GroupEntity::class,
            parentColumns = arrayOf("group_id"),
            childColumns = arrayOf("group_id"),
        ),
        ForeignKey(
            entity = TagEntity::class,
            parentColumns = arrayOf("tag_id"),
            childColumns = arrayOf("tag_id"),
        ),
    ]
)
class TagsGroupsCrossRef(
    @ColumnInfo(name = "tag_id") val tagId: Long,
    @ColumnInfo(name = "group_id") val groupId: Long
)