package ru.sevastianov.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.UserProfile


interface IUserRepository {

    fun getUserProfile(): Flow<UserProfile>

}