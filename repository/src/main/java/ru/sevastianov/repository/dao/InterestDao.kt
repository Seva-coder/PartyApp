package ru.sevastianov.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.sevastianov.repository.entities.MytInterestEntity


@Dao
interface InterestDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(interest: MytInterestEntity)

    @Query("SELECT exists(SELECT * FROM my_interests)")
    fun isInterestsExist(): Flow<Boolean>

}