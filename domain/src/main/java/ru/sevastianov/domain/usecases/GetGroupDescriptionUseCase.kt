package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.repository.IGroupsRepository


internal class GetGroupDescriptionUseCase(private val repository: IGroupsRepository) : IGetGroupDescription {

    override fun execute(groupId: Long): Flow<GroupDescription> {
        return repository.getGroupDescription(groupId = groupId)
    }

}


interface IGetGroupDescription {
    fun execute(groupId: Long): Flow<GroupDescription>
}