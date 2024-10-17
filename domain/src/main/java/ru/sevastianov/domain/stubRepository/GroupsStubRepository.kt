package ru.sevastianov.domain.stubRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.Group
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.repository.IGroupsRepository


class GroupsStubRepository : IGroupsRepository {

    override fun getAllGroups(): Flow<List<Group>> {
        val allGroups = listOf(
            Group(name = "Linux", numberPerson = 12, imgUrl = "http://live.staticflickr.com/65535/53844284150_5c59f30792_o_d.png"),
            Group(name = "Группа 2", numberPerson = 3, imgUrl = "https://slm-assets.secondlife.com/assets/3789225/lightbox/512x512%20PNG%20Landscape%20Texture%20-%20Country%20Lane.jpg?1308962600"),
            Group(name = "Сходка 1", numberPerson = 21, imgUrl = "https://slm-assets.secondlife.com/assets/3806158/view_large/512x512%20PNG%20Landscape%20Texture%20-%20Sunrise%20Lake.jpg?1309205114"),
            Group(name = "Designa", numberPerson = 10000, imgUrl = "https://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg"),
            Group(name = "Designa", numberPerson = 10000, imgUrl = "http://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg"),
            Group(name = "Designa", numberPerson = 10000, imgUrl = "https://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg"),
            Group(name = "Designa", numberPerson = 10000, imgUrl = "https://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg"),
            Group(name = "Designa", numberPerson = 10000, imgUrl = "http://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg")
        )
        return flowOf(allGroups)
    }

    override fun getEventsOfGroup(groupId: Long): Flow<List<Event>> {
        val event = Event(
            eventId = 1L,
            title = "Developer meeting",
            place = "Москва",
            date = 3456780,
            imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
            tags = listOf("Python", "Junior", "Moscow")
        )
        val eventsOfGroup = List(5) { event }
        return flowOf(eventsOfGroup)
    }

    override fun getGroupDescription(groupId: Long): Flow<GroupDescription> {
        val groupDescription = GroupDescription(
            name = "",
            imageUrl = "",
            description = "Description \n \n \n Description",
            subscribed = false
        )
        return flowOf(groupDescription)
    }

    override fun getGroupDescriptionByEventId(eventId: Long): Flow<GroupDescription> {
        return flowOf()
    }
}