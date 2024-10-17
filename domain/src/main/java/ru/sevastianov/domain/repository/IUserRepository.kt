package ru.sevastianov.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.ParticipantAvatar
import ru.sevastianov.domain.models.UserAvaNameTag
import ru.sevastianov.domain.models.UserProfile


interface IUserRepository {

    fun getUserProfile(): Flow<UserProfile>

    //
    fun getEventUserAvatars(eventId: Long): Flow<List<ParticipantAvatar>>
    fun getEventUsers(eventId: Long): Flow<List<UserAvaNameTag>>

}