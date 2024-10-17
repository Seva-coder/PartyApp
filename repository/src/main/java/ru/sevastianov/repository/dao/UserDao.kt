package ru.sevastianov.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.sevastianov.repository.entities.UserEntity
import ru.sevastianov.repository.entities.UserImage
import ru.sevastianov.repository.entities.UserWithAvaNameTag


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: UserEntity)

    @Query(
        "SELECT users.avatar_url AS userAvatarUrl FROM events JOIN UsersEventsCrossRef ON events.event_id = UsersEventsCrossRef.event_id " +
                "JOIN users ON UsersEventsCrossRef.user_id = users.user_id " +
                "WHERE events.event_id = (:eventId)"
    )
    fun getEventUsersAvatars(eventId: Long): Flow<List<UserImage>>

    @Query(
        "SELECT users.avatar_url AS imageUrl, users.user_id AS userId, users.name AS name, tags.tag_name AS tag FROM events JOIN UsersEventsCrossRef ON events.event_id = UsersEventsCrossRef.event_id " +
                "JOIN users ON UsersEventsCrossRef.user_id = users.user_id " +
                "JOIN tags ON users.tag_id = tags.tag_id " +
                "WHERE events.event_id = (:eventId)"
    )
    fun getEventUsers(eventId: Long): Flow<List<UserWithAvaNameTag>>

}