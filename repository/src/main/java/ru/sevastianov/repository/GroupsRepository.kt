package ru.sevastianov.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.Group
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.repository.IGroupsRepository

internal class GroupsRepository(val context: Context) : IGroupsRepository {
    override fun getAllGroups(): Flow<List<Group>> {
        TODO("Not yet implemented")
    }

    override fun getEventsOfGroup(groupId: Long): Flow<List<Event>> {
        TODO("Not yet implemented")
    }

    override fun getGroupDescription(groupId: Long): Flow<GroupDescription> {
        TODO("Not yet implemented")
    }

}