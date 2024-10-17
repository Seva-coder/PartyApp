package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import ru.sevastianov.domain.models.UserAvaNameTag
import ru.sevastianov.domain.repository.IUserRepository


internal class GetEventUsers(val repository: IUserRepository, innerIdsFlow: InnerEventDetailsIds) :
    IGetEventUsers {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val result = innerIdsFlow.observe().flatMapLatest { eventId ->
        repository.getEventUsers(eventId)
    }


    override fun execute(): Flow<List<UserAvaNameTag>> {
        return result
    }

}

interface IGetEventUsers {
    fun execute(): Flow<List<UserAvaNameTag>>
}