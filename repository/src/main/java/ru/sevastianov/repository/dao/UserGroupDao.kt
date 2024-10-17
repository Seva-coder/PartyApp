package ru.sevastianov.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.sevastianov.repository.entities.UsersGroupsCrossRef


@Dao
interface UserGroupDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userGroupRef: UsersGroupsCrossRef)
}