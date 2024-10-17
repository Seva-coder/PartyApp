package ru.sevastianov.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sevastianov.domain.models.ParticipantAvatar
import ru.sevastianov.domain.models.UserAvaNameTag
import ru.sevastianov.domain.models.UserProfile
import ru.sevastianov.domain.repository.IUserRepository
import ru.sevastianov.repository.dao.UserDao


internal class UserRepository(
    val context: Context,
    val userDao: UserDao,
    val converter: Entity2Domain
) : IUserRepository {

    override fun getUserProfile(): Flow<UserProfile> {
        TODO("Not yet implemented")
    }

    override fun getEventUserAvatars(eventId: Long): Flow<List<ParticipantAvatar>> {
        val entitiesFlow = userDao.getEventUsersAvatars(eventId)

        val domainFlow = entitiesFlow.map {
            it.map { user -> converter.userAvatars2domain(user) }
        }

        return domainFlow
    }

    override fun getEventUsers(eventId: Long): Flow<List<UserAvaNameTag>> {
        val entitiesFlow = userDao.getEventUsers(eventId)

        val domainFlow = entitiesFlow.map {
            it.map { user -> converter.userInfo2domain(user) }
        }

        return domainFlow
    }


}