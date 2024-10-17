package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow


internal class InnerSelectedEventTags {

    // позволяет избежать запроса с default-параметром в случае StateFlow
    private val streamTagsIds = MutableSharedFlow<Set<Long>>(replay = 1)

    fun update(newSet: Set<Long>) {
        streamTagsIds.tryEmit(newSet)
    }

    fun observe(): Flow<Set<Long>> = streamTagsIds

}