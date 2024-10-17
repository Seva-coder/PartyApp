package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tags")
class TagEntity(
    @ColumnInfo(name = "tag_id") @PrimaryKey(autoGenerate = true) val tagId: Long,
    @ColumnInfo(name = "tag_name") val nameTag: String
)