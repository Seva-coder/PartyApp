package ru.sevastianov.wb.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.sevastianov.domain.usecases.IGetActiveEventsUseCase
import ru.sevastianov.domain.usecases.IGetAllEventsUseCase
import ru.sevastianov.wb.ui.extensions.toUI
import ru.sevastianov.wb.ui.models.EventUI

class EventsVM(val getAllEventsUseCase: IGetAllEventsUseCase, val getActiveEventsUseCase: IGetActiveEventsUseCase) : ViewModel() {

    private val eventsListFlow = MutableStateFlow<List<EventUI>>(emptyList())
    private val immutableEventsListFlow: StateFlow<List<EventUI>> = eventsListFlow
    fun getAllEvents() = immutableEventsListFlow

    private val eventsActiveListFlow = MutableStateFlow<List<EventUI>>(emptyList())
    private val immutableActiveEventsListFlow: StateFlow<List<EventUI>> = eventsActiveListFlow
    fun getActiveEvents() = immutableActiveEventsListFlow

    init {
        updateEvents()
    }

    private fun updateEvents() {
        viewModelScope.launch {  // Dispatchers.IO будет через withContext в репозитории по месту
            getAllEventsUseCase.execute().collect { newList ->
                eventsListFlow.value = newList.map { it.toUI() }
            }

            getActiveEventsUseCase.execute().collect { newList ->
                eventsActiveListFlow.value = newList.map { it.toUI() }
            }
        }
    }

}