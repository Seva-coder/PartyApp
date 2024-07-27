package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.Coordinates
import ru.sevastianov.domain.models.EventDetails
import ru.sevastianov.domain.models.Participant
import ru.sevastianov.domain.repository.IEventsRepository

internal class GetEventDetailsUseCase(private val repository: IEventsRepository) : IGetEventDetails {

    override fun execute(eventId: Long): Flow<EventDetails> {
        return flowOf(mockEventDetails)
    }

    private val mockEventDetails = EventDetails(
        chips = listOf("1", "2", "345"),
        date = 345678,
        place = "Вишневогрск",
        coordinates = Coordinates(56.00, -180.00),
        description = "descr \n \n \n \n 12345",
        iGoing = false,
        participants = listOf(
            Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
            Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
            Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
            Participant("https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png"),
            Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
            Participant("https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png"),
            Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
        )
    )
}


interface IGetEventDetails {
    fun execute(eventId: Long): Flow<EventDetails>
}