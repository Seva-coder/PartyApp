package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "users",
    foreignKeys = [
        ForeignKey(
            entity = TagEntity::class,
            parentColumns = arrayOf("tag_id"),
            childColumns = arrayOf("tag_id"),
        )
    ]
)
class UserEntity(
    @ColumnInfo(name = "user_id") @PrimaryKey(autoGenerate = true) val userId: Long,
    @ColumnInfo(name = "avatar_url") val avatarUrl: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "tag_id") val tagId: Long
)