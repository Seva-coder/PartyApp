package ru.sevastianov.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.UserProfile
import ru.sevastianov.domain.repository.IUserRepository

internal class UserRepository(val context: Context) : IUserRepository {

    override fun getUserProfile(): Flow<UserProfile> {
        TODO("Not yet implemented")
    }


}