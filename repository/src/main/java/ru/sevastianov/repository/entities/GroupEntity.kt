package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "groups")
class GroupEntity(
    @ColumnInfo(name = "group_id") @PrimaryKey(autoGenerate = true) val groupId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "logo_url") val logoUrl: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "subscribed") val subscribed: Boolean,
)