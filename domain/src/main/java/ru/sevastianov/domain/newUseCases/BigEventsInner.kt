package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository


// этот класс SINGLE в koin
internal class BigEventsInnerUseCase(repository: IEventsRepository) {

    private val _bigEventsFlow = repository.getAllBigEvents()

    fun getBigEventsFlow(): Flow<List<Event>> {
        return _bigEventsFlow
    }

}