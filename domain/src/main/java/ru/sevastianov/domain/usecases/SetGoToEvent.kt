package ru.sevastianov.domain.usecases

import ru.sevastianov.domain.repository.IEventsRepository


class SetGoToEvent(val repository: IEventsRepository) : ISetGoToEvent {

    override fun execute(goingToEvent: Boolean, eventId: Long) {

    }


}


interface ISetGoToEvent {
    fun execute(goingToEvent: Boolean, eventId: Long)
}