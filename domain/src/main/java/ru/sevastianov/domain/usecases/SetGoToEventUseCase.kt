package ru.sevastianov.domain.usecases

import ru.sevastianov.domain.repository.IEventsRepository


internal class SetGoToEventUseCase(private val repository: IEventsRepository) : ISetGoToEvent {

    override fun execute(goingToEvent: Boolean, eventId: Long) {
        repository.setGoToEvent(goingToEvent = goingToEvent, eventId = eventId)
    }

}


interface ISetGoToEvent {
    fun execute(goingToEvent: Boolean, eventId: Long)
}