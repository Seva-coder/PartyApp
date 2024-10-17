package ru.sevastianov.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.sevastianov.repository.entities.UsersEventsCrossRef


@Dao
interface UserEventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userEventRef: UsersEventsCrossRef)
}