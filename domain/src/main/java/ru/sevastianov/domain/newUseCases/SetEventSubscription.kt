package ru.sevastianov.domain.newUseCases

import ru.sevastianov.domain.repository.IEventsRepository


class SetEventSubscription(val repository: IEventsRepository) : ISetEventSubscription {
    override fun execute(eventId: Long, setSubscription: Boolean) {
        repository.setSubscribeToEvent(eventId = eventId, setSubscribed = setSubscription)
    }
}


interface ISetEventSubscription {
    fun execute(eventId: Long, setSubscription: Boolean): Unit
}