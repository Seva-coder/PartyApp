package ru.sevastianov.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.Group
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.repository.IGroupsRepository
import ru.sevastianov.repository.dao.GroupDao


internal class GroupsRepository(
    val context: Context,
    private val groupDao: GroupDao,
    private val converter: Entity2Domain
) : IGroupsRepository {
    override fun getAllGroups(): Flow<List<Group>> {
        TODO("Not yet implemented")
    }

    override fun getEventsOfGroup(groupId: Long): Flow<List<Event>> {
        TODO("Not yet implemented")
    }

    override fun getGroupDescription(groupId: Long): Flow<GroupDescription> {
        TODO("Not yet implemented")
    }

    ///

    override fun getGroupDescriptionByEventId(eventId: Long): Flow<GroupDescription> {
        val entitiesFlow = groupDao.getGroupDescriptionByEventId(eventId)

        val domainFlow = entitiesFlow.map { groupEntity ->
            converter.group2domain(groupEntity)
        }

        return domainFlow
    }


}