package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow


internal class InnerNearestEvents {

    // позволяет избежать запроса с default-параметром в случае StateFlow
    private val streamAfterTime = MutableSharedFlow<Int>(replay = 1)

    fun update(time: Int) {
        streamAfterTime.tryEmit(time)
    }

    fun observe(): Flow<Int> = streamAfterTime

}