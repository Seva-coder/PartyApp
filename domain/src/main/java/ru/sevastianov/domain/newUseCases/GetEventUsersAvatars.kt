package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import ru.sevastianov.domain.models.ParticipantAvatar
import ru.sevastianov.domain.repository.IUserRepository


internal class GetEventUsersAvatars(
    val repository: IUserRepository,
    innerIdsFlow: InnerEventDetailsIds
) : IGetEventUsersAvatars {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val result = innerIdsFlow.observe().flatMapLatest { eventId ->
        repository.getEventUserAvatars(eventId)
    }

    override fun execute(): Flow<List<ParticipantAvatar>> {
        return result
    }

}


interface IGetEventUsersAvatars {
    fun execute(): Flow<List<ParticipantAvatar>>
}