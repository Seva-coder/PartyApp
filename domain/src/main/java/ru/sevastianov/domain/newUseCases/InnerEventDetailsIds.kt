package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow


internal class InnerEventDetailsIds {

    private val eventId = MutableSharedFlow<Long>(replay = 1)

    fun update(time: Long) {
        eventId.tryEmit(time)
    }

    fun observe(): Flow<Long> = eventId

}