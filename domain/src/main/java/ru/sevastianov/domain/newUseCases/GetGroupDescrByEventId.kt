package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.repository.IGroupsRepository


internal class GetGroupDescrByEventId(
    val repository: IGroupsRepository,
    eventsIdsFlow: InnerEventDetailsIds
) : IGetGroupDescrByEventId {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val result = eventsIdsFlow.observe().flatMapLatest { ids ->
        repository.getGroupDescriptionByEventId(ids)
    }

    override fun execute(): Flow<GroupDescription> {
        return result
    }

}


interface IGetGroupDescrByEventId {
    fun execute(): Flow<GroupDescription>
}