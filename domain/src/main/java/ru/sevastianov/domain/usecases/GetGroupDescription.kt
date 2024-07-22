package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.repository.IGroupsRepository

class GetGroupDescription(val repository: IGroupsRepository) : IGetGroupDescription {
    override fun execute(groupId: Long): Flow<GroupDescription> {
        return flowOf(mockGroupDescription)
    }

    private val mockGroupDescription = GroupDescription(
        description = "Description \n \n \n Description"
    )
}


interface IGetGroupDescription {
    fun execute(groupId: Long): Flow<GroupDescription>
}