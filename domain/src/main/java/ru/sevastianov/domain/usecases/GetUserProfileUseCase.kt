package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.UserProfile
import ru.sevastianov.domain.repository.IUserRepository

internal class GetUserProfileUseCase(private val repository: IUserRepository) : IGetUserProfile {

    override fun execute(): Flow<UserProfile> {
        return repository.getUserProfile()
    }

}

interface IGetUserProfile {
    fun execute(): Flow<UserProfile>
}