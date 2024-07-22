package ru.sevastianov.wb.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.sevastianov.domain.usecases.IGetEventDetails
import ru.sevastianov.domain.usecases.ISetGoToEvent
import ru.sevastianov.wb.ui.extensions.toUI
import ru.sevastianov.wb.ui.models.EventDetailsUI

class EventDetailsVM(val getEventDetails: IGetEventDetails, val setGoToEvent: ISetGoToEvent) : ViewModel() {

    private val eventDetailsFlow = MutableStateFlow(EventDetailsUI())
    private val immutableDetailsFlow: StateFlow<EventDetailsUI> = eventDetailsFlow
    fun getDetails() = immutableDetailsFlow


    fun setEventId(id: Long) {
        viewModelScope.launch {
            getEventDetails.execute(id).collect { details ->
                eventDetailsFlow.value = details.toUI()
            }
        }
    }

    fun setGoToEvent(state: Boolean, eventId: Long) {
        setGoToEvent.execute(goingToEvent = state, eventId = eventId)
    }

}