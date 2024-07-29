package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Group
import ru.sevastianov.domain.repository.IGroupsRepository


internal class GetAllGroupsUseCase(private val repository: IGroupsRepository) : IGetAllGroups {

    override fun execute(): Flow<List<Group>> {
        return repository.getAllGroups()
    }

}

interface IGetAllGroups {
    fun execute(): Flow<List<Group>>
}