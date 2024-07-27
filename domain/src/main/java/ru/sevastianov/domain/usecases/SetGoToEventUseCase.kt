package ru.sevastianov.domain.usecases

import ru.sevastianov.domain.repository.IUserRepository


internal class SetGoToEventUseCase(private val repository: IUserRepository) : ISetGoToEvent {

    override fun execute(goingToEvent: Boolean, eventId: Long) {

    }


}


interface ISetGoToEvent {
    fun execute(goingToEvent: Boolean, eventId: Long)
}