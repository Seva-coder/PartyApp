package ru.sevastianov.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "my_interests",
    foreignKeys = [
        ForeignKey(
            entity = TagEntity::class,
            parentColumns = arrayOf("tag_id"),
            childColumns = arrayOf("interest_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class MytInterestEntity(
    @ColumnInfo(name = "interest_id") @PrimaryKey val interestId: Long
)