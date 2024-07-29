package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IGroupsRepository


internal class GetEventsOfGroupUseCase(private val repository: IGroupsRepository) : IGetGroupEvents {

    override fun execute(groupId: Long): Flow<List<Event>> {
        return repository.getEventsOfGroup(groupId = groupId)
    }

}

interface IGetGroupEvents {
    fun execute(groupId: Long): Flow<List<Event>>
}