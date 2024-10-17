package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class InnerFilteredEvents {

    // позволяет избежать запроса с default-параметром в случае StateFlow
    private val streamTextFilter = MutableSharedFlow<String>(replay = 1)

    fun update(newString: String) {
        streamTextFilter.tryEmit(newString)
    }

    fun observe(): Flow<String> = streamTextFilter

}