package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    primaryKeys = ["user_id", "group_id"],
    foreignKeys = [
        ForeignKey(
            entity = GroupEntity::class,
            parentColumns = arrayOf("group_id"),
            childColumns = arrayOf("group_id"),
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = arrayOf("user_id"),
            childColumns = arrayOf("user_id"),
        ),
    ]
)
class UsersGroupsCrossRef(
    @ColumnInfo(name = "user_id") val userId: Long,
    @ColumnInfo(name = "group_id") val groupId: Long
)