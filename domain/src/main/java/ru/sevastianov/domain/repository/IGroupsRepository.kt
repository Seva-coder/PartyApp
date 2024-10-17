package ru.sevastianov.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.Group
import ru.sevastianov.domain.models.GroupDescription


interface IGroupsRepository {

    fun getAllGroups(): Flow<List<Group>>
    fun getEventsOfGroup(groupId: Long): Flow<List<Event>>
    fun getGroupDescription(groupId: Long): Flow<GroupDescription>

    ///

    fun getGroupDescriptionByEventId(eventId: Long): Flow<GroupDescription>

}