package ru.sevastianov.wb.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.sevastianov.domain.usecases.IGetOldEventsUseCase
import ru.sevastianov.domain.usecases.IGetPlannedEventsUseCase
import ru.sevastianov.wb.ui.extensions.toUI
import ru.sevastianov.wb.ui.models.EventUI

class MyEventsVM(private val getLastEventsUseCase: IGetOldEventsUseCase, private val getPlannedEventsUseCase: IGetPlannedEventsUseCase) : ViewModel() {

    private val eventsPlannedFlow = MutableStateFlow<List<EventUI>>(emptyList())
    private val immutablePlannedFlow: StateFlow<List<EventUI>> = eventsPlannedFlow
    internal fun getPlannedEvents() = immutablePlannedFlow

    private val eventsLastFlow = MutableStateFlow<List<EventUI>>(emptyList())
    private val immutableLastFlow: StateFlow<List<EventUI>> = eventsLastFlow
    internal fun getLastEvents() = immutableLastFlow

    init {
        updateEvents()
    }

    private fun updateEvents() {
        viewModelScope.launch {  // Dispatchers.IO будет через withContext в репозитории по месту
            getLastEventsUseCase.execute().collect { newList ->
                eventsLastFlow.value = newList.map { it.toUI() }
            }

            getPlannedEventsUseCase.execute().collect { newList ->
                eventsPlannedFlow.value = newList.map { it.toUI() }
            }
        }
    }

}