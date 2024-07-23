package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IGroupsRepository

internal class GetEventsOfGroupUseCase(private val repository: IGroupsRepository) : IGetGroupEvents {

    override fun execute(groupId: Long): Flow<List<Event>> {
        return flowOf(mockGroupEvents)
    }

    private val event = Event(
        title = "Developer meeting",
        place = "Москва",
        date = 3456780,
        isEnded = false,
        imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
        tags = listOf("Python", "Junior", "Moscow")
    )

    private val mockGroupEvents = List(5) { event }

}

interface IGetGroupEvents {
    fun execute(groupId: Long): Flow<List<Event>>
}